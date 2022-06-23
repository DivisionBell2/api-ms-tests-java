package ru.projects.db;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import ru.projects.ConfigQA;
import ru.projects.dictionary.Service;
import ru.projects.entities.EntityData;
import ru.projects.utils.Utils;

import javax.persistence.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RSMapper<T> {
    private static final Class<EntityData> ENTITY_DATA_CLASS = EntityData.class;
    private static final String QUERY = "select * from %s where 1=1 %s";

    public List<T> mapResultSet(Class clazz, boolean isId, Object value) {
        List<T> outputList = new ArrayList<>();
        if (String.valueOf(value).isEmpty()) {
            return outputList;
        }

        String table = null;
        String dbName = null;
        Service  service = null;
        try {
            table = getAnnotationValue(clazz, Table.class, "name");
            service = Service.valueOf(getAnnotationValue(clazz, Table.class, "schema"));
            dbName = ConfigQA.getInstance().getServiceDbName(service); // this is not a schema this is just a database name
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assert dbName != null;
        Connection connection = PostgreSQLJDBC.getInstance(service);

        String queryString = isId
                ? String.format(QUERY, table, "and id in (" + value + ") ") : String.format(QUERY, table, value);

        try (PreparedStatement statement = connection.prepareStatement(queryString)) {
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                if (clazz.isAnnotationPresent(Entity.class)) {
                    List<Field> fieldsList = getAllFields(clazz);
                    while (rs.next()) {
                        T bean = (T) clazz.newInstance();
                        for (Field field : fieldsList) {
                            setFieldProperty(rs, field, bean, connection);
                        }
                        outputList.add(bean);
                    }
                } else {
                    throw new RuntimeException("Отсутствует аннотация '(@javax.persistence.)Entity' у класса '" + clazz.getSimpleName()
                            + "'.");
                }
            } else {

                return null;
            }
        } catch (InstantiationException | SQLException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return outputList;
    }

    private static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }

    private void setFieldProperty(ResultSet resultSet, Field field, T bean, Connection connection)
            throws SQLException, InvocationTargetException, IllegalAccessException, InstantiationException {
        if (field.isAnnotationPresent(Column.class)) {
            Column column = field.getAnnotation(Column.class);
            setProperty(resultSet, bean, field, column);
        } else if (field.isAnnotationPresent(ElementCollection.class) && field.isAnnotationPresent(JoinTable.class)) {
            ElementCollection collection = field.getAnnotation(ElementCollection.class);
            JoinTable joinTable = field.getAnnotation(JoinTable.class);
            setPropertyList(resultSet, bean, field, collection, joinTable, connection);
        }
    }

    private static void checkField(Object bean, String fieldName) {
        try {
            if (BeanUtils.getProperty(bean, fieldName) == null) {
                throw new RuntimeException("Bean field value didn't set. Field: " + fieldName + ". Bean: " + bean.toString());
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void setPropertyList(ResultSet resultSet, Object bean, Field field, ElementCollection collection, JoinTable table, Connection connection)
            throws InvocationTargetException, IllegalAccessException, SQLException {
        //FIXME
        Object value;
        Long id = (Long) resultSet.getObject("id");

        String foreignKey = table.foreignKey().name();
        JoinColumn[] joinColumns = table.joinColumns();
        List<String> columnNames = new ArrayList<>();
        for (JoinColumn joinColumn : joinColumns) {
            columnNames.add(joinColumn.name());
        }
        assert columnNames.size() == 1;
        String column = columnNames.get(0);

        String targetClassTable = getAnnotationValue(collection.targetClass(), Table.class, "name");

        String refTableQuery = String.format("select %s from %s f JOIN %s s ON f.%s = s.id where %s = %d",
                column, table.name(), targetClassTable, column, foreignKey, id);

        try (PreparedStatement statement = connection.prepareStatement(refTableQuery)) {
            ResultSet rs = statement.executeQuery();
            List<String> ids = new ArrayList<>();
            while (rs.next()) {
                ids.add(String.valueOf(rs.getObject(column)));
            }
            value = mapResultSet(collection.targetClass(), true, String.join(", ", ids));
        }
        BeanUtils.setProperty(bean, field.getName(), value);
    }

    private void setProperty(ResultSet resultSet, Object bean, Field field, Column column)
            throws InvocationTargetException, IllegalAccessException, SQLException {
        String columnName = column.name();
        Object columnValue = null;
        if (Utils.hasField(resultSet, columnName)) {
            columnValue = resultSet.getObject(columnName);
        } else {
            return;
        }

        Object value = null;

        if (ENTITY_DATA_CLASS.isAssignableFrom(field.getType())) {
            List<T> list = mapResultSet(field.getType(), true, columnValue);
            if (list.size() > 0) {
                value = list.get(0);
            }
        } else if (field.getType().isEnum()) {
            Class clazz = field.getType();
            value = Enum.valueOf(clazz, String.valueOf(columnValue));
        } else {
            value = columnValue;
        }
        BeanUtilsBean.getInstance().getConvertUtils().register(false, true, 0);
        BeanUtils.setProperty(bean, field.getName(), value);
    }

    private static String getAnnotationValue(Class clazz, Class<? extends Annotation> annotationClass, String key)
            throws InvocationTargetException, IllegalAccessException {
        Annotation annotation = clazz.getAnnotation(annotationClass);
        Method[] methods = new Method[0];
        if (annotation != null) {
            methods = annotation.annotationType().getDeclaredMethods();
        } else {
            throw new RuntimeException(
                    String.format("Couldn't find annotation for class '%s', annotation class '%s', key '%s'",
                            clazz, annotationClass, key));
        }
        String result = null;
        for (Method method : methods) {
            if (method.getName().equals(key)) {
                result = String.valueOf(method.invoke(annotation, null));
            }
        }
        return result;
    }
}

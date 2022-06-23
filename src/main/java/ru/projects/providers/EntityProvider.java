package ru.projects.providers;

import ru.projects.db.RSMapper;
import ru.projects.entities.EntityData;
import ru.projects.helpers.assert_helper.AssertHelper;

import javax.persistence.Table;
import java.util.List;

public class EntityProvider<T extends EntityData> implements Provider {
    private RSMapper<T> resultSetMapper = new RSMapper<>();
    private Class<T> aClass;

    public EntityProvider(Class<T> aClass) {
        this.aClass = aClass;
    }

    @Override
    public T getById(long id) {
        return  getById(id, false);
    }

    public T getById(long id, Boolean canBeNull) {
        List<T> entityList = resultSetMapper
                .mapResultSet(aClass, true, String.valueOf(id));
        if (!canBeNull)
            AssertHelper.assertTrue(!entityList.isEmpty(), String.format("Check that object with id '%d' is present in database '%s'.", id,
                aClass.getAnnotation(Table.class).name()));
        if (canBeNull && entityList.size() == 0)
            return  null;
         return entityList.get(0);

    }

    public T getById(String id) {
        return  getById(id, false);
    }
    
    public T getById(String id,  Boolean canBeNull) {
        List<T> entityList = resultSetMapper
                .mapResultSet(aClass, true, id);
        if (!canBeNull)
        AssertHelper.assertTrue(!entityList.isEmpty(), String.format("Check that object with id '%s' is present in database '%s'.", id,
                aClass.getAnnotation(Table.class).name()));
        if (!canBeNull && entityList.size() == 0)
            return  null;
        return entityList.get(0);
    }

    @Override
    public List<T> getAll() {
        return resultSetMapper.mapResultSet(aClass, false, "and 1=1");
    }

    private T getResult(String condition) {
        List<T> entityList = resultSetMapper.mapResultSet(aClass, false, condition);
        return !entityList.isEmpty() ? entityList.get(0) : null;
    }
}
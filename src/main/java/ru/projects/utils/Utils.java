package ru.projects.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Utils {

    public static boolean hasField(ResultSet rs, String fieldName) throws SQLException {
        boolean result = false;

        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();

        // get the column names; column indexes start from 1
        for (int i = 1; i < numberOfColumns + 1; i++) {
            String columnName = rsMetaData.getColumnName(i);
            // Get the name of the column's table name
            if (fieldName.equals(columnName)) {
                result = true;
            }
        }
        return result;
    }
}
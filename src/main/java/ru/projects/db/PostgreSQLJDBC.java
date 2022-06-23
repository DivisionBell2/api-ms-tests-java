package ru.projects.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.projects.ConfigQA;
import ru.projects.dictionary.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class PostgreSQLJDBC {
    private static final Logger LOGGER = LogManager.getLogger(PostgreSQLJDBC.class);
    private static final String DRIVER = "org.postgresql.Driver";
    private static Map<Service, Connection> connectionMap = new HashMap<>();

    public static Connection getInstance(Service service) {
        Connection connection = connectionMap.get(service);
        if (connection == null) {
            connection = getConnection(service);
            connectionMap.put(service, connection);
        }
        return connection;
    }

    private static Connection getConnection(Service service) {
        Connection connection = null;
        try {
            Class.forName(DRIVER);

            String dbUrl = ConfigQA.getInstance().getParams().getDbConnectUrl();
            connection = DriverManager
                    .getConnection(String.format("%s/%s", dbUrl, ConfigQA.getInstance().getServiceDbName(service)),
                            ConfigQA.getInstance().getServiceDbNameUser(service),
                            ConfigQA.getInstance().getServiceDbNamePass(service));
            
        } catch (Exception e) {
            LOGGER.debug("PostgreSql exception: ", e);
        }
        LOGGER.debug("'" + ConfigQA.getInstance().getServiceDbName(service) + "' connection opened successfully");
        return connection;
    }
}
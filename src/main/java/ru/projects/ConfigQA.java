package ru.projects;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Getter;
import ru.projects.dictionary.Service;

import java.util.HashMap;

import static ru.projects.dictionary.Service.STORAGE_RBO;
import static ru.projects.dictionary.Service.DOCS;

public class ConfigQA {
    private static ConfigQA singleInstance = null;
    @Getter
    private final Params params = new Params();

    private final HashMap<Service, NamedConfig> configHashMap = new HashMap<>();
    private final HashMap<Service, DBUsers> dbconnections = new HashMap<>();

    public static ConfigQA getInstance() {
        if (singleInstance == null)
            synchronized (ConfigQA.class) {
                singleInstance = new ConfigQA();
            }

        return singleInstance;
    }

    public String getServiceDbName(Service service) {
        return configHashMap.get(service).dbName;
    }

    public String getServiceDbNameUser(Service service) {
        return dbconnections.get(service).getUserName();
    }

    public String getServiceDbNamePass(Service service) {
        return dbconnections.get(service).getPassword();
    }

    public String getServiceUrl(Service service) {
        return configHashMap.get(service).url;
    }

    private ConfigQA() {
        final Config configBase = ConfigFactory.parseResources("config.conf");
        final Config config = configBase.getConfig(params.getProduct());
        final String prefSubdomain = configBase.getString("stages." + params.getProfile());
        final String domain = config.getString("domain");
        final Config dbNames = config.getConfig("database.services");
        final Config urls = config.getConfig("services_api");

        final boolean isPreUat = params.profile.equalsIgnoreCase("preUAT");
        final Config users = isPreUat ? config.getConfig("database.users.uat") : config.getConfig("database.users." + params.getProfile());

        final String defDbUsername = params.getDefaultDBAdmin();
        final String defDbPassword = params.getDefaultDBAdminPass();
        final String sysServiceName = System.getProperty("serviceName") == null ? "single-auth" : System.getProperty("serviceName").replace("-", "");
        final String sysServiceUrl = System.getProperty("serviceUrl");
        final String sysDbName = System.getProperty("dbName");

        dbNames.entrySet().forEach(e -> {
            final String fieldName = e.getKey();

            try {
                String url, dbName;
                if (isAppUat(fieldName)) {
                    url = String.format("http://%s.%s.%s", urls.getString(fieldName), configBase.getString("stages.appUat"), domain);
                } else {
                    url = String.format("https://%s.%s.%s", urls.getString(fieldName), prefSubdomain, domain);
                }

                if (isPreUat && fieldName.equalsIgnoreCase(sysServiceName)) {
                    url = sysServiceUrl;
                    dbName = sysDbName;
                } else {
                    dbName = (String) e.getValue().unwrapped();
                }

                configHashMap.put(Service.valueOf(Service.class, fieldName), new NamedConfig(dbName, url));
                dbconnections.put(Service.valueOf(Service.class, fieldName),
                        users.hasPath(fieldName + "User") && users.hasPath(fieldName + "Pass")
                                ? new DBUsers(users.getString(fieldName + "User"), users.getString(fieldName + "Pass"))
                                : new DBUsers(defDbUsername, defDbPassword));
            } catch (final Exception t) {
                System.out.println(fieldName + ": " + t.getMessage());
            }
        });
    }

    private Boolean isAppUat(String fieldName) {
        Service[] servicesAppUat = {STORAGE_RBO, DOCS};
        for (Service service : servicesAppUat) {
            if (fieldName.equals(service.name())) {
                return true;
            }
        }
        return false;
    }

    public static class NamedConfig {
        public final String dbName;
        public final String url;

        public NamedConfig(final String dbName, final String url) {
            this.dbName = dbName;
            this.url = url;
        }

        @Override
        public String toString() {
            return "{"
                    + "dbName='" + dbName + '\''
                    + ", url='" + url + '\''
                    + '}';
        }
    }

    @Getter
    public static class DBUsers {
        private final String userName;
        private final String password;

        public DBUsers(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }
    }

    @Getter
    public static class Params {
        private final Config configBase = ConfigFactory.parseResources("config.conf");
        private String schema;
        private String product;
        private String profile;
        private final String dbConnectUrl;
        private final String gmailUserName;
        private final String gmailUserPassword;
        private final String yandexUserPassword;
        private final String yandexUserName;
        private final String dasredaUserName;
        private final String dasredaUserPassword;
        private final String adminUserName;
        private final String adminUserPass;
        private final Long adminUserId;
        private final String defaultDBAdmin;
        private final String defaultDBAdminPass;

        private Params() {
            profile = System.getProperty("profile") != null ? System.getProperty("profile") : "uat"; // is taken from POM file
            schema = System.getProperty("schema", "public"); // is taken from POM file
            product = System.getProperty("product") != null ? System.getProperty("product") : "dasreda";

            if (configBase.hasPath("default")) {
                final Config def = configBase.getConfig("default");

                if (def.hasPath("product")) product = def.getString("product");
                if (def.hasPath("schema")) schema = def.getString("schema");
                if (def.hasPath("profile")) profile = def.getString("profile");
            }
            Config config = configBase.getConfig(product); // read values of Product  config
            dbConnectUrl = config.getString("database." + profile + "_connect_url"); // read main config url to DB ( it may be UAT or DEV)

            defaultDBAdmin = config.getString("database.username");
            defaultDBAdminPass = config.getString("database.password");

            gmailUserName = configBase.getString("gmailUserName");
            gmailUserPassword = configBase.getString("gmailUserPassword");
            yandexUserPassword = configBase.getString("yandexUserPassword");
            yandexUserName = configBase.getString("yandexUserName");
            dasredaUserName = configBase.getString("dasredaUserName");
            dasredaUserPassword = configBase.getString("dasredaUserPassword");
            adminUserName = config.getString("AdminUserName");
            adminUserPass = config.getString("AdminPass");
            adminUserId = config.getLong("AdminUserID");
        }

        public boolean isBcSchema() {
            return schema.equalsIgnoreCase("bc");
        }
    }
}



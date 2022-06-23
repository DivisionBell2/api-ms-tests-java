package ru.projects.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import ru.projects.ConfigQA;
import ru.projects.dictionary.Service;
import ru.projects.entities.auth.EmailAuthData;
import ru.projects.entities.auth.UserAppsDTO;
import ru.projects.entities.core.personal.dto.GeneralDataUsersPersDto;
import ru.projects.entities.core.router.UserAgreementsDto;
import ru.projects.entities.core.router.v2.*;
import ru.projects.entities.orb.dto.*;
import ru.projects.entities.orb.dto.dataRequests.OrbDataRequestsDTO;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtils {
    private static final Logger LOGGER = LogManager.getLogger(HibernateUtils.class);

    private static final String DIALECT = "org.hibernate.dialect.PostgreSQL9Dialect";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = ConfigQA.getInstance().getParams().getDbConnectUrl();
    private static final String DEFAULT_SCHEMA = ConfigQA.getInstance().getParams().getSchema();

    private static EnumMap<Service, Session> sessionMap = new EnumMap<>(Service.class);

    public static Session openSession(Service service) {
        if (!sessionMap.containsKey(service)) {
            sessionMap.put(service, createSession(service));
        }
        return sessionMap.get(service);
    }

    private static Session createSession(Service service) {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(getSettings(service));
        Metadata metadata = getMetadata(service, registryBuilder.build());
        return metadata.getSessionFactoryBuilder().build().openSession();
    }

    private static Map<String, String> getSettings(Service service) {
        Map<String, String> settings = new HashMap<>();
        LOGGER.debug("Заполнить параметры для создания сессии");
        settings.put(Environment.DRIVER, DRIVER);
        LOGGER.debug("Environment.DRIVER = " + settings.get(Environment.DRIVER));
        settings.put(Environment.DEFAULT_SCHEMA, DEFAULT_SCHEMA);
        LOGGER.debug("Environment.DEFAULT_SCHEMA = " + settings.get(Environment.DEFAULT_SCHEMA));
        settings.put(Environment.URL, URL + "/" + ConfigQA.getInstance().getServiceDbName(service));
        LOGGER.debug("Environment.URL = " + settings.get(Environment.URL));
        settings.put(Environment.USER, ConfigQA.getInstance().getServiceDbNameUser(service));
        LOGGER.debug("Environment.USER = " + settings.get(Environment.USER));
        settings.put(Environment.PASS, ConfigQA.getInstance().getServiceDbNamePass(service));
        LOGGER.debug("Environment.PASS = " + settings.get(Environment.PASS));
        settings.put(Environment.DIALECT, DIALECT);
        LOGGER.debug("Environment.DIALECT = " + settings.get(Environment.DIALECT));
        return settings;
    }
    private static Metadata getMetadata(Service service, StandardServiceRegistry registry) {
        MetadataSources metadata = new MetadataSources(registry);
        switch (service) {
            case SERVICE:
                metadata.addAnnotatedClass(GeneralDataUsersPersDto.class);
                break;
            case OBR:
                metadata.addAnnotatedClass(OrbBankEmployeesDTO.class)
                        .addAnnotatedClass(OrbDataRequestsDTO.class);
                break;
            case AUTH:
                metadata.addAnnotatedClass(UserAppsDTO.class)
                        .addAnnotatedClass(EmailAuthData.class);
                break;
            case ROUTER:
                metadata.addAnnotatedClass(AgreementDocDto.class)
                        .addAnnotatedClass(UserAgreementsCoopDto.class)
                        .addAnnotatedClass(UserBackActionsDto.class)
                        .addAnnotatedClass(OAuth20PartnerDTO.class)
                        .addAnnotatedClass(CoopRegChannelDto.class)
                        .addAnnotatedClass(UserAgreements.class)
                        .addAnnotatedClass(UserAgreementsV2.class)
                        .addAnnotatedClass(RegChannels.class)
                        .addAnnotatedClass(RegChannelsV2.class)
                        .addAnnotatedClass(UserAgreementsDto.class);
                break;
            default:
                throw new IllegalArgumentException(String.format(
                        "Illegal '%s' DBName . That basename should be allowed in HibberUtils.",
                        service));
        }
        return metadata.getMetadataBuilder().build();
    }
}

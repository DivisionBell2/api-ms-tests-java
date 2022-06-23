package ru.projects.entities.core.router.v2.userRBO;

import com.typesafe.config.Config;
import ru.projects.utils.RandomUtils;

public class UserORBFactory {

    public static UserORB getRandomUserRBO() {
        String firstName = RandomUtils.getRandomFirstName();
        String middleName = RandomUtils.getRandomMiddleName();
        String lastName = RandomUtils.getRandomLastName();

        return UserORB
                .builder()
                .custom("{\"start_url\":\"https://rbo.uat.dasreda.ru/\",\"entry_url\":\"https://rbo.uat.dasreda.ru/\"}")
                .startUrl("")
                .email(RandomUtils.getRandomGoogleEmail())
                .referrer("")
                .password("7jnOqHNa1234")
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .username(lastName + " " + firstName + " " + middleName)
                .build();
    }

    public static UserORB getCustomUserRBO() {
            String firstName = "Тест";
            String middleName = "Тестович";
            String lastName = "Тестовый";
            String phoneNumber = "+79120000000";

        return UserORB
                .builder()
                .custom("{\"start_url\":\"https://rbo.uat.dasreda.ru/\",\"entry_url\":\"https://rbo.uat.dasreda.ru/\"}")
                .startUrl("")
                .email(RandomUtils.getRandomGoogleEmail())
                .referrer("")
                .password("7jnOqHNa1234")
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .username(lastName + " " + firstName + " " + middleName)
                .phone(phoneNumber)
                .build();
    }

    public static UserORB getRandoumUserORBWithPhone() {
            String firstName = RandomUtils.getRandomFirstName();
            String middleName = RandomUtils.getRandomMiddleName();
            String lastName = RandomUtils.getRandomLastName();

            return UserORB
                    .builder()
                    .custom("{\"start_url\":\"https://rbo.uat.dasreda.ru/\",\"entry_url\":\"https://rbo.uat.dasreda.ru/\"}")
                    .startUrl("")
                    .email(RandomUtils.getRandomGoogleEmail())
                    .referrer("")
                    .password("7jnOqHNa1234")
                    .firstName(firstName)
                    .middleName(middleName)
                    .lastName(lastName)
                    .username(lastName + " " + firstName + " " + middleName)
                    .phone(RandomUtils.nextPhone())
                    .build();
        }

    public static UserORB getRBOAdminUser(Config rboConfig) {

        return UserORB
                .builder()
                .email(rboConfig.getString("rbo.adminUserEmail"))
                .password(rboConfig.getString("rbo.adminUserPassword"))
                .id(rboConfig.getLong("rbo.adminUserID"))
                .build();
    }
}

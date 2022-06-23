package ru.projects.entities.ca.json.registerrequest.consumer;

import ru.projects.entities.ca.json.registerrequest.consumer.addresses.AddressesJsonFactory;
import ru.projects.entities.ca.json.registerrequest.consumer.identities.IdentitiesJsonFactory;
import ru.projects.entities.orb.json.userdata.UserDataJson;

public class ConsumerJsonFactory {

    public static ConsumerJson getConsumerJson(UserDataJson userData) {
        return ConsumerJson.builder()
                .addresses(AddressesJsonFactory.getAddressesJsonList(userData))
                .gender("M")
                .inn(userData.getInn())
                .lastName(userData.getLastName())
                .middleName(userData.getMiddleName())
                .firstName(userData.getFirstName())
                .ssoId(userData.getSsoId())
                .birthed(userData.getBirthDate())
                .identities(IdentitiesJsonFactory.getIdentitiesJsonList(userData))
                .phone(userData.getPhone().replace("+", ""))
                .snils(userData.getSnils())
                .id(userData.getSsoId().toString())
                .build();
    }
}

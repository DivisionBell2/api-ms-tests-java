package ru.projects.entities.ca.json.registerrequest.consumer.addresses;

import ru.projects.entities.orb.json.userdata.UserDataJson;

import java.util.ArrayList;
import java.util.List;

public class AddressesJsonFactory {

    public static List<AddressesJson> getAddressesJsonList(UserDataJson userData) {

        List<AddressesJson> addresses = new ArrayList();
        addresses.add(AddressesJson
                .builder()
                .city(userData.getAddress().getCity())
                .street(userData.getAddress().getStreet())
                .index(userData.getAddress().getPostalCode())
                .type("permanent")
                .region(userData.getAddress().getRegionCode())
                .house(userData.getAddress().getHouse())
                .apartment(userData.getAddress().getFlat())
                .build());

        return addresses;
    }
}

package ru.projects.entities.orb.json.userdata;

import ru.projects.entities.core.router.v2.userRBO.UserORB;
import ru.project.entities.orbCommon.json.address.AddressJson;
import ru.projects.utils.RandomUtils;

public class UserDataJsonFactory {
    public static UserDataJson getUserDataJson(AddressJson address, UserORB userORB, String id) {
        return UserDataJson
                .builder()
                .address(address)
                .birthDate("1980-12-12")
                .birthPlace("г.Москва")
                .firstName(userORB.getFirstName())
                .lastName(userORB.getLastName())
                .middleName(userORB.getMiddleName())
                .ssoId(userORB.getId())
                .inn(RandomUtils.getRandomINN())
                .passportGivenBy("УВД")
                .passportGivenDate("2012-12-12")
                .passportGivenDept("123-123")
                .passportSeria("5500")
                .passportNumber("121212")
                .snils("59731906540")
                .sexMale(true)
                .registryAddress(address.getPostalCode() + ", " + address.getResult())
                .email(userORB.getEmail())
                .phone(userORB.getPhone())
                .requestId(Long.parseLong(id))
                .build();
    }

    public static UserDataJson getCustomUserDataJson(AddressJson address, UserORB userORB, String id) {
        return UserDataJson
                .builder()
                .address(address)
                .birthDate("1980-12-12")
                .birthPlace("г.Москва")
                .firstName(userORB.getFirstName())
                .lastName(userORB.getLastName())
                .middleName(userORB.getMiddleName())
                .ssoId(userORB.getId())
                .inn("329347883399")
                .passportGivenBy("УВД")
                .passportGivenDate("2012-12-12")
                .passportGivenDept("123-123")
                .passportSeria("5500")
                .passportNumber("121212")
                .snils("59731906540")
                .sexMale(true)
                .registryAddress(address.getPostalCode() + ", " + address.getResult())
                .email(userORB.getEmail())
                .phone(userORB.getPhone())
                .requestId(Long.parseLong(id))
                .build();
    }
}

package ru.projects.entities.ca.json.registerrequest.consumer.identities;

import ru.projects.entities.orb.json.userdata.UserDataJson;

import java.util.ArrayList;
import java.util.List;

public class IdentitiesJsonFactory {

    public static List<IdentitiesJson> getIdentitiesJsonList(UserDataJson userData) {
        List identities = new ArrayList();

        identities.add(
                IdentitiesJson
                        .builder()
                        .type("internal-passport")
                        .series(userData.getPassportSeria())
                        .number(userData.getPassportNumber())
                        .issuedBy(userData.getPassportGivenBy())
                        .issueCode(userData.getPassportGivenDept())
                        .issued(userData.getPassportGivenDate())
                        .build()
        );

        return identities;
    }
}
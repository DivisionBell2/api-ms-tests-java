package ru.projects.steps.orb;

import io.restassured.RestAssured;
import ru.projects.ConfigQA;
import ru.projects.dictionary.Service;
import ru.projects.entities.auth.LoginForm;
import ru.projects.entities.core.router.v2.userRBO.UserORB;
import ru.project.entities.orbCommon.json.address.AddressJson;
import ru.projects.entities.orb.json.userdata.UserDataJson;
import ru.projects.entities.orb.json.userdata.UserDataJsonFactory;
import ru.projects.enums.orb.RequestTypes;
import ru.projects.enums.orb.UserRegistrationSources;
import ru.projects.steps.UserDataSteps;

import java.io.UnsupportedEncodingException;

public class OrbIntegrationSteps {
    private final static String UNI_RBO_BASE_URL = ConfigQA.getInstance().getServiceUrl(Service.OBR);

    private static final String ADDRESS_NAME = "Новосибирск Ленина 2";

    public static UserDataJson createUserRequestForRequest() {
        AddressJson address;
        UserDataJson data;
        UserORB userORB = UserDataSteps.registerNewORBUser(UserRegistrationSources.ORB.toString());
        LoginForm loginForm = new LoginForm(true, userORB.getEmail(), userORB.getPassword());

        String baseUri = RestAssured.baseURI;
        RestAssured.baseURI = UNI_RBO_BASE_URL;

        String id = OrbRequestSteps.postCreateNewRequest(loginForm, RequestTypes.ENTREPRENEUR).getBody().jsonPath().getString("id");
        OrbPhoneSteps.getValidationPhoneNumber(loginForm, id, userORB.getPhone());

        try {
            address = OrbDataSteps.getAddressHints(loginForm, ADDRESS_NAME).then().extract().body().as(AddressJson[].class)[0];
            data = UserDataJsonFactory.getUserDataJson(address, userORB, id);
            RestAssured.baseURI = baseUri;
            return data;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

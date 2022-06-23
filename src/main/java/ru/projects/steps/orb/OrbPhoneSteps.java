package ru.projects.steps.orb;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.projects.entities.auth.LoginForm;
import ru.projects.helpers.ApiHelper;
import static java.net.HttpURLConnection.HTTP_OK;
import static ru.projects.helpers.assert_helper.AssertHelper.assertStatus;
import static ru.projects.steps.orb.OrbPath.*;

public class OrbPhoneSteps {

    final static String PATH_USER_PHONE = PATH_USER  + PATH_PHONE;

    @Step("Phone number validation request")
    public static Response getValidationPhoneNumber(LoginForm loginForm, String id, String phone) {
        String path = pathRequest + "/" + id + PATH_USER_PHONE + "/" + phone + PATH_CODE;
        Response response = ApiHelper.getByPathAndValue(loginForm, path, "");
        assertStatus(response, HTTP_OK);

        return response;
    }

    @Step("Checking is phone validation exists")
    public static Response getIsPhoneValidated(LoginForm loginForm, String id, String phone) {
        String path = pathRequest + "/" + id + PATH_USER_PHONE + "/" + phone;
        Response response = ApiHelper.getByPathAndValue(loginForm, path, "");
        assertStatus(response, HTTP_OK);

        return response;
    }
}

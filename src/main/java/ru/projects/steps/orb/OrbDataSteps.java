package ru.projects.steps.orb;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import ru.projects.entities.auth.LoginForm;
import ru.projects.helpers.ApiHelper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static java.net.HttpURLConnection.HTTP_OK;
import static ru.projects.helpers.assert_helper.AssertHelper.assertJsonIsValid;
import static ru.projects.helpers.assert_helper.AssertHelper.assertStatus;
import static ru.projects.steps.orb.OrbPath.*;

public class OrbDataSteps {

    @Step("Get address hints")
    public static Response getAddressHints(LoginForm loginForm, String address) throws UnsupportedEncodingException {
        Boolean encodingEnabled = RestAssured.urlEncodingEnabled;
        RestAssured.urlEncodingEnabled = false;

        String path = VERSION + PATH_DADATA + PATH_ADDRESS + PATH_SUGGESTION + "/" + URLEncoder.encode(address, "UTF-8").replaceAll("\\+", "%20");
        Response response = ApiHelper.getByPath(loginForm, path);
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);

        RestAssured.urlEncodingEnabled = encodingEnabled;

        return response;
    }
}
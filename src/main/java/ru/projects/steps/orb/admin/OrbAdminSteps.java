package ru.projects.steps.orb.admin;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.projects.entities.auth.LoginForm;
import ru.projects.helpers.ApiHelper;

import static java.net.HttpURLConnection.HTTP_OK;
import static ru.projects.helpers.assert_helper.AssertHelper.*;
import static ru.projects.steps.orb.OrbPath.*;
import static ru.projects.steps.orb.OrbPath.pathAdmin;

public class OrbAdminSteps {
    @Step("Getting current app state")
    public static Response getCurrentAppState() {
        Response response = ApiHelper.getByPathAndValue(pathAdmin + PATH_APP_STATE, "");
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);

        return response;
    }

    @Step("Getting bankList")
    public static Response getBankList() {
        Response response = ApiHelper.getByPathAndValue(pathRefs + PATH_BANKS, "");
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);

        return response;
    }

    @Step("Getting current state")
    public static Response getCurrentState() {
        Response response = ApiHelper.getByPathAndValue(pathAdmin + PATH_STATE, "");
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);

        return response;
    }

    @Step("Getting identification points")
    public static Response getIdentificationPoints() {
        Response response = ApiHelper.getByPathAndValue(
                pathAdmin + PATH_CA + PATH_IDENTIFICATION_POINT, "");
        assertStatus(response, HTTP_OK);

        return response;
    }

    @Step("Getting all states list")
    public static Response getAllStates(LoginForm loginForm) {
        Response response = ApiHelper.getByPathAndValue(loginForm, pathAdmin + PATH_APP_STATES, "");
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);

        return response;
    }

    @Step("Getting incident State")
    public static Response getIncidentState(LoginForm loginForm) {

        Response response = ApiHelper.getByPath(loginForm,
                pathAdmin + PATH_REF + PATH_INCIDENT + PATH_STATES);
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);
        return response;
    }

    @Step("Getting incident role list")
    public static Response getIncidentRoleList(LoginForm loginForm) {

        Response response = ApiHelper.getByPath(loginForm,
                pathAdmin + PATH_REF + PATH_INCIDENT + PATH_ROLES);
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);
        return response;
    }

    @Step("Getting incident types list")
    public static Response getIncidentTypesList(LoginForm loginForm) {

        Response response = ApiHelper.getByPath(loginForm,
                pathAdmin + PATH_REF + PATH_INCIDENT + PATH_TYPES);
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);
        return response;
    }
}
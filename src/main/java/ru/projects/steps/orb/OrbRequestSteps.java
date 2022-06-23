package ru.projects.steps.orb;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.projects.entities.auth.LoginForm;
import ru.projects.enums.orb.RequestTypes;
import ru.projects.helpers.ApiHelper;

import java.util.HashMap;
import java.util.Map;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;
import static ru.projects.helpers.assert_helper.AssertHelper.assertJsonIsValid;
import static ru.projects.helpers.assert_helper.AssertHelper.assertStatus;
import static ru.projects.steps.orb.OrbPath.*;

public class OrbRequestSteps {

    @Step("Getting request by type")
    public static Response getRequestByType(LoginForm loginForm, String requestType) {
        Map<String, String> type = new HashMap<>();
        type.put("type", requestType.toLowerCase());

        Response response = ApiHelper.getByPathAndValue(loginForm, pathRequest, "", type);
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);

        return response;
    }

    @Step("Create new request")
    public static Response postCreateNewRequest(LoginForm loginForm, RequestTypes type) {
        Map<String, Object> data = new HashMap<>();
        data.put("type", type.toString().toLowerCase());

        Response response = ApiHelper.post(loginForm, pathRequest, new Gson().toJson(data));
        assertStatus(response, HTTP_CREATED);
        assertJsonIsValid(response);

        return response;
    }

    @Step("Add agent to request")
    public static void putCreateRequestWithAgent(LoginForm loginForm, String id, long agentNumber) {
        Response response = ApiHelper.put(loginForm, pathRequest + "/" + id + PATH_AGENT + "/" + agentNumber, new HashMap<>());
        assertStatus(response, HTTP_OK);
    }
}
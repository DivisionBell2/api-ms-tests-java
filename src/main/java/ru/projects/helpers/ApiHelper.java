package ru.projects.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.projects.entities.EntityData;
import ru.projects.entities.JsonConverter;
import ru.projects.entities.auth.LoginForm;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiHelper {
    private static final Logger LOGGER = LogManager.getLogger(ApiHelper.class);

    private static void logResponse(Response response) {
        LOGGER.debug("Response code: " + response.getStatusCode());
        LOGGER.debug("Response message: " + response.asString());
    }

    // POST methods
    @Step("Send post request")
    public static Response post(LoginForm loginForm, String path, String jsonString) {
        Response response = SendRequestHelper.post(loginForm, path, jsonString);
        logResponse(response);
        return response;
    }

    @Step("Send post request with token")
    public static Response post(LoginForm loginForm, String path, File file) {
        Response response = SendRequestHelper.post(loginForm, path, file);
        logResponse(response);
        return response;
    }

    @Step("Send post request with token")
    public static Response post(LoginForm loginForm, String path, File file, Map<String, ?> params) {
        Response response = SendRequestHelper.post(loginForm, path, file, params);
        logResponse(response);
        return response;
    }

    @Step("Send post request with mimeType")
    public static Response post(LoginForm loginForm, String path, File file, String mimeType) {
        Response response = SendRequestHelper.postWithMimeType(loginForm, path, file, mimeType);
        logResponse(response);
        return response;
    }

    @Step("Send post request with mimeType")
    public static Response post(Map<String, String> header, String path, File file, String mimeType) {
        Response response = SendRequestHelper.postWithMimeTypeAndHeaders(header, path, file, mimeType);
        logResponse(response);
        return response;
    }

    @Step("Send post request")
    public static Response post(String path, String jsonString) {
        return post(null, path, jsonString);
    }

    @Step("Send post request")
    public static Response post(String path) {
        Response response = SendRequestHelper.postNoType(null, path);
        logResponse(response);
        return response;
    }

    @Step("Send post request")
    public static Response postNoType(LoginForm loginForm, String path) {
        Response response = SendRequestHelper.postNoType(loginForm, path);
        logResponse(response);
        return response;
    }

    @Step("Send post request")
    public static Response post(LoginForm loginForm, String path, Map<String, ?> parameters) {
        Response response = SendRequestHelper.post(loginForm, path, parameters);
        logResponse(response);
        return response;
    }

    @Step("Send post request")
    public static Response post(LoginForm loginForm, String path, Object o, Map<String, ?> pathParam, Map<String, ?> queryParams) {
        Response response = SendRequestHelper.post(loginForm, path, o, pathParam, queryParams);
        logResponse(response);
        return response;
    }

    @Step("Send post request and modified header and jsonBody")
    public static Response postWithAuthAndHeader(Map<String, String> header, String path, String json) {
        Response response = SendRequestHelper.postWithHeader(null, header, path, json);
        logResponse(response);
        return response;
    }

    @Step("Send post request and modified header and jsonBody")
    public static Response postWithAuthAndHeader(Map<String, String> header, String path) {
        Response response = SendRequestHelper.postWithHeader(null, header, path);
        logResponse(response);
        return response;
    }

    @Step("Send post request and modified header and jsonBody")
    public static Response postWithHeaderAndFile(Map<String, String> header, String path, File file) {
        Response response = SendRequestHelper.postWithHeader(null, header, path, file);
        logResponse(response);
        return response;
    }

    @Step("Send post request")
    public static Response post(LoginForm loginForm, String path, Object o) {
        Response response = SendRequestHelper.post(loginForm, path, o);
        logResponse(response);
        return response;
    }

    @Step("Send post request")
    public static Response post(LoginForm loginForm, String path, Object o, Map<String, String> pathParam) {
        Response response = SendRequestHelper.post(loginForm, path, o, pathParam);
        logResponse(response);
        return response;
    }

    @Step("Send post request")
    public static Response post(String path, File file, Map<String, ?> parameters) {
        Response response = SendRequestHelper.post(null, path, file, parameters);
        logResponse(response);
        return response;
    }

    @Step("Send post request")
    public static Response post(LoginForm loginForm, String path, String controlName, File file, String mimeType, String baseUri) {
        Response response = SendRequestHelper.post(loginForm, path, controlName, file, mimeType, baseUri);
        logResponse(response);
        return response;
    }

    @Step("Send post request")
    public static Response post(String path, File file, Map<String, ?> parameters, String json) {
        Response response = SendRequestHelper.post(null, path, file, parameters, json);
        logResponse(response);
        return response;
    }

    @Step("Send post request")
    public static Response post(String path, Map<String, ?> parameters) {
        return post(null, path, parameters);
    }

    @Step("Send post request")
    public static Response post(String path, Map<String, ?> parameters, String bodyJsonString) {
        return SendRequestHelper.post(null, path, parameters, bodyJsonString);
    }

    @Step("Send post request")
    public static Response post(String path, File file) {
        return post(null, path, file);
    }

    @Step("Send post request")
    public static Response post(LoginForm loginForm, String path) {
        Response response = SendRequestHelper.post(loginForm, path);
        logResponse(response);
        return response;
    }

    @Step("Send put request")
    public static Response put(LoginForm loginForm, String path, String jsonString) {
        Response response = SendRequestHelper.put(loginForm, path, jsonString);
        logResponse(response);
        return response;
    }

    public static Response put(String path, String jsonString) {
        return put(null, path, jsonString);
    }

    @Step("Send put request")
    public static Response put(LoginForm loginForm, String path, Object o) {
        Response response = SendRequestHelper.put(loginForm, path, o);
        logResponse(response);
        return response;
    }

    @Step("Send put request")
    public static Response put(LoginForm loginForm, String path, Object o, Map<String, String> pathParam) {
        Response response = SendRequestHelper.put(loginForm, path, o, pathParam);
        logResponse(response);
        return response;
    }

    @Step("Send put request")
    public static Response put(String path) {
        Response response = SendRequestHelper.putWithoutContentType(null, path);
        logResponse(response);
        return response;
    }

    @Step("Send put request")
    public static Response put(LoginForm loginForm, String path, File file) {
        Response response = SendRequestHelper.put(loginForm, path, file);
        logResponse(response);
        return response;
    }

    @Step("Send put request with custom headers and without body")
    public static Response putWithAuthAndHeader(Map<String, String> header, String path) {
        Response response = SendRequestHelper.putWithHeader(null, header, path);
        logResponse(response);
        return response;
    }

    @Step("Send put request with query params and without auth")
    public static Response put(String path, Map<String, ?> parameters, Object body) {
        return SendRequestHelper.put(path, parameters, body);
    }

    @Step("Send put request with query params")
    public static Response put(LoginForm loginForm, String path, Map<String, ?> parameters, String bodyJsonString) {
        return SendRequestHelper.put(loginForm, path, parameters, bodyJsonString);
    }

    @Step("Send get request")
    public static Response getByPathWithCustomBaseUrl(LoginForm loginForm, String path, String baseUrl) {
        Response response = SendRequestHelper.get(loginForm, path, baseUrl);
        logResponse(response);
        return response;
    }

    @Step("Send get request")
    public static Response getByPathAndValue(LoginForm loginForm, String path, String value,
                                             Map<String, ?> params) {
        String p = (value.length() > 0) ? path + "/" : path;
        Response response = SendRequestHelper.get(loginForm, String.format("%s%s", p, value),
                params);
        logResponse(response);
        return response;
    }

    public static Response getByPathAndValue(String path, String value,
                                             Map<String, String> params) {
        return getByPathAndValue(null, path, value, params);
    }

    public static Response getByPathAndValue(String path, Map<String, ?> params) {
        return getByPathAndValue(null, path, "", params);
    }

    public static Response getByPathAndValue(LoginForm loginForm, String path,
                                             Map<String, String> params) {
        return getByPathAndValue(loginForm, path, "", params);
    }

    public static Response getByPathAndValue(LoginForm loginForm, String path, String value) {
        return getByPathAndValue(loginForm, path, value, new HashMap<>());
    }

    public static Response getByPathAndValue(String path, Object value) {
        return getByPathAndValue(null, path, String.valueOf(value), new HashMap<>());
    }

    public static Response getByPath(LoginForm loginForm, String path) {
        return getByPathAndValue(loginForm, path, "");
    }

    public static Response getByPath(String path) {
        return getByPathAndValue(null, path, "");
    }

    public static Response getWithHeader(Map<String, String> headers, String path) {
        Response response = SendRequestHelper.getWithHeader(headers, path);
        logResponse(response);
        return response;
    }

    public static Response getWithAuthAndHeader(Map<String, String> headers, String path) {
        Response response = SendRequestHelper.getWithHeader(null, headers, path);
        logResponse(response);
        return response;
    }

    public static Response getById(LoginForm loginForm, String path, long id) {
        return getByPathAndValue(loginForm, path, String.valueOf(id));
    }

    public static Response getById(String path, long id) {
        return getByPathAndValue(null, path, String.valueOf(id));
    }

    @Step("Send put request")
    public static Response update(LoginForm loginForm, String path, String jsonString) {
        Response response = SendRequestHelper.put(loginForm, path, jsonString);
        logResponse(response);
        return response;
    }

    public static Response update(String path, String jsonString) {
        return update(null, path, jsonString);
    }

    @Step("Send post request")
    public static Response update(String path, Map<String, ?> parameters, String bodyJsonString) {
        return SendRequestHelper.put(null, path, parameters, bodyJsonString);
    }

    @Step("Send put request")
    public static Response update(LoginForm loginForm, String path, long id, String jsonString) {
        Response response = SendRequestHelper.put(loginForm, String.format("%s/%s", path, id), jsonString);
        return response;
    }

    public static Response update(String path, long id, String jsonString) {
        return update(null, path, id, jsonString);
    }

    @Step("Send put request")
    public static Response update(LoginForm loginForm, String path) {
        return SendRequestHelper.put(loginForm, path);
    }

    @Step("Send put request")
    public static Response update(String path) {
        return SendRequestHelper.put(null, path);
    }

    @Step("Send delete request")
    public static Response delete(LoginForm loginForm, String path, String jsonString) {
        Response response = SendRequestHelper.delete(loginForm, path, jsonString);
        logResponse(response);
        return response;
    }

    @Step("Send delete request")
    public static Response delete(LoginForm loginForm, String path) {
        return delete(loginForm, path, "");
    }

    public static <T extends EntityData> T getObjectFromMap(Object obj, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(obj, clazz);
    }
}
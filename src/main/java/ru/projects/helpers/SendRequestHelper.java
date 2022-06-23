package ru.projects.helpers;

import com.github.viclovsky.swagger.coverage.SwaggerCoverageRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import ru.projects.ConfigQA;
import ru.projects.allure.AllureFilter;
import ru.projects.dictionary.Service;
import ru.projects.entities.auth.LoginForm;
import ru.projects.utils.JsonMethods;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SendRequestHelper {
    private static final String APPLICATION_JSON = "application/json";
    private static final String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
    private static final String TEXT_TYPE = "text/plain; charset=UTF-8";
    private static final String PATH_LOGIN = "/v1/login";
    private static final String MULTIPART = "multipart/form-data";
    private static final Map<String, String> TOKENS = new HashMap<>();
    static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(SendRequestHelper.class);
    private static final ConfigQA.Params CONFIG_PARAMS = ConfigQA.getInstance().getParams();
    private static final LoginForm DEFAULT_FORM = new LoginForm(true, CONFIG_PARAMS.getAdminUserName(), CONFIG_PARAMS.getAdminUserPass());

    private static LoginForm getLogin(LoginForm loginForm) {
        String token;
        LoginForm login;

        if (loginForm != null) {
            token = TOKENS.get(loginForm.getUsername());
            login = loginForm;
        } else {
            token = TOKENS.get(DEFAULT_FORM.getUsername());
            login = DEFAULT_FORM;
        }
        if (token == null) {
            authorize(login);
        }
        return login;
    }

    private static void authorize(LoginForm loginForm) {
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigQA.getInstance().getServiceUrl(Service.AUTH)).build();
        RequestSpecification requestSpecification = given(spec)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .body(loginForm.toJsonString());
        Response r = getHeaderIssuerAndSchema(requestSpecification).post(PATH_LOGIN);
        LOGGER.debug("Auth response : " + r.asString());
        String token = JsonMethods.getResponseParam(r, "token");
        TOKENS.put(loginForm.getUsername(), token);
    }

    public static Response post(LoginForm loginForm, String path, String bodyJsonString) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .body(bodyJsonString)
                .post(path);
    }

    public static Response post(LoginForm loginForm, String path, List<?> list) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .body(list)
                .post(path);
    }

    public static Response post(LoginForm loginForm, String path, Object o) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .body(o)
                .post(path);
    }

    public static Response post(LoginForm loginForm, String path, Object o, Map<String, String> pathParam) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .pathParams(pathParam)
                .body(o)
                .post(path);
    }

    public static Response post(LoginForm loginForm, String path, Object o, Map<String, ?> pathParam, Map<String, ?> queryParams) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .pathParams(pathParam)
                .queryParams(queryParams)
                .body(o)
                .post(path);
    }

    public static Response post(LoginForm loginForm, String path) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .post(path);
    }

    public static Response post(LoginForm loginForm, String path, File file) {
        return getBaseRS(getLogin(loginForm).getUsername())
                .multiPart(file)
                .post(path);
    }

    public static Response postWithMimeType(LoginForm loginForm, String path, File file, String mimeType) {
        return getBaseRS(getLogin(loginForm).getUsername())
                .multiPart(getMultipartRS(file, mimeType))
                .post(path);
    }

    public static Response postWithMimeTypeAndHeaders(Map<String, String> header, String path, File file, String mimeType) {
        List<Header> headers = new ArrayList<>();
        for (Map.Entry<String, String> iter : header.entrySet()) {
            headers.add(new Header(iter.getKey(), iter.getValue()));
        }
        return   getBaseRSWithOutLoginAndType()
                .headers(new Headers(headers))
                .multiPart(getMultipartRS(file, mimeType))
                .post(path);
    }

    public static Response post(LoginForm loginForm, String path, String controlName, File file, String mimeType, String baseUri) {
        return getBaseRS(getLogin(loginForm).getUsername()).baseUri(baseUri)
                .multiPart(controlName, file, mimeType)
                .post(path);
    }

   public static Response post(LoginForm loginForm, String path, File file, Map<String, ?> parameters) {
        return getBaseRS(getLogin(loginForm).getUsername())
                .queryParams(parameters)
                .multiPart(file)
                .post(path);
    }

    public static Response post(LoginForm loginForm, String path, File file, Map<String, ?> parameters, String bodyJsonString) {
        return getReqSpecWithQueryParamsAndBody(loginForm, parameters, bodyJsonString)
                .params(parameters)
                .multiPart(file)
                .post(path);
    }

    public static Response post(LoginForm loginForm, String path, Map<String, ?> parameters) {
        return getBaseRS(getLogin(loginForm).getUsername())
            .queryParams(parameters)
            .post(path);
    }

    public static Response post(LoginForm loginForm, String path, Map<String, ?> parameters,
        String bodyJsonString) {
        return getReqSpecWithQueryParamsAndBody(loginForm, parameters, bodyJsonString).post(path);
    }

    public static Response postNoType(LoginForm loginForm, String path) {
        return getBaseRS(getLogin(loginForm).getUsername())
                .post(path);
    }

    public static Response postWithHeader(Map<String, String> header, String path, String json) {
        List<Header> headers = new ArrayList<>();
        for (Map.Entry<String, String> iter : header.entrySet()) {
            headers.add(new Header(iter.getKey(), iter.getValue()));
        }
        return getBaseRSWithOutLogin()
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .headers(new Headers(headers))
                .body(json)
                .post(path);
    }

    public static Response postWithHeader(LoginForm loginForm, Map<String, String> header, String path, String json) {
        List<Header> headers = new ArrayList<>();
        for (Map.Entry<String, String> iter : header.entrySet()) {
            headers.add(new Header(iter.getKey(), iter.getValue()));
        }
        return getBaseRS(getLogin(loginForm).getUsername())
                .contentType(APPLICATION_JSON)
                .headers(new Headers(headers))
                .body(json)
                .post(path);
    }

    public static Response postWithHeader(LoginForm loginForm, Map<String, String> header, String path) {
        List<Header> headers = new ArrayList<>();
        for (Map.Entry<String, String> iter : header.entrySet()) {
            headers.add(new Header(iter.getKey(), iter.getValue()));
        }
        return getBaseRS(getLogin(loginForm).getUsername())
                .headers(new Headers(headers))
                .post(path);
    }

    public static Response postWithHeader(LoginForm loginForm, Map<String, String> header, String path, File file) {
        List<Header> headers = new ArrayList<>();
        for (Map.Entry<String, String> iter : header.entrySet()) {
            headers.add(new Header(iter.getKey(), iter.getValue()));
        }
        return getBaseRS(getLogin(loginForm).getUsername())
                .headers(new Headers(headers))
                .multiPart(file)
                .post(path);
    }

    public static Response getWithHeader(Map<String, String> headers, String path) {
        List<Header> hds = new ArrayList<>();
        for (Map.Entry<String, String> iter : headers.entrySet()) {
            hds.add(new Header(iter.getKey(), iter.getValue()));
        }
        return getBaseRSWithOutLogin()
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .headers(new Headers(hds))
                .get(path);
    }

    public static Response getWithHeader(LoginForm loginForm, Map<String, String> headers, String path) {
        List<Header> hds = new ArrayList<>();
        for (Map.Entry<String, String> iter : headers.entrySet()) {
            hds.add(new Header(iter.getKey(), iter.getValue()));
        }
        return getBaseRS(getLogin(loginForm).getUsername())
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .headers(new Headers(hds))
                .get(path);
    }

    public static Response get(LoginForm loginForm, String path, String baseUrl) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .baseUri(baseUrl)
                .get(path);
    }

    public static Response get(LoginForm loginForm, String path, Map<String, ?> params) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
            .params(params)
            .get(path);
    }

    public static Response put(LoginForm loginForm, String path, String bodyJsonString) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .body(bodyJsonString)
                .put(path);
    }

    public static Response put(LoginForm loginForm, String path, Object o) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .body(o)
                .put(path);
    }

    public static Response put(LoginForm loginForm, String path, Object o, Map<String, String> pathParam) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .pathParams(pathParam)
                .body(o)
                .put(path);
    }

    public static Response put(LoginForm loginForm, String path) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .put(path).peek();
    }

    public static Response putWithoutContentType(LoginForm loginForm, String path) {
        return getBaseRSWithoutContTypeJson(getLogin(loginForm).getUsername())
                .put(path).peek();
    }

    public static Response put(LoginForm loginForm, String path, Map<String, ?> parameters,
        String bodyJsonString) {
        return getReqSpecWithQueryParamsAndBody(loginForm, parameters, bodyJsonString).put(path);
    }

    public static Response put(String path, Map<String, ?> queryParams, Object o) {
        return getBaseRSWithOutAuth()
                .queryParams(queryParams)
                .body(o)
                .put(path);
    }

    public static Response put(LoginForm loginForm, String path, File file) {
        return getBaseRS(getLogin(loginForm).getUsername())
            .multiPart(file)
            .put(path);
    }

    public static Response put(LoginForm loginForm, String path, File file, Map<String, ?> params) {
        return getBaseRS(getLogin(loginForm).getUsername())
                .queryParams(params)
                .multiPart(file)
                .put(path);
    }

    public static Response putWithHeader(LoginForm loginForm, Map<String, String> header, String path) {
        List<Header> headers = new ArrayList<>();
        for (Map.Entry<String, String> iter : header.entrySet()) {
            headers.add(new Header(iter.getKey(), iter.getValue()));
        }
        return getBaseRS(getLogin(loginForm).getUsername())
                .accept(APPLICATION_JSON)
                .headers(new Headers(headers))
                .put(path);
    }

    public static Response delete(LoginForm loginForm, String path, String bodyJsonString) {
        return getBaseRSWithContTypeJson(getLogin(loginForm).getUsername())
                .body(bodyJsonString)
                .delete(path);
    }

    private static RequestSpecification getBaseRSWithOutLogin() {
        RequestSpecification requestSpecification = given().log().all(true)
                .filter(new AllureFilter())
                .filter(new SwaggerCoverageRestAssured())
                .contentType(APPLICATION_FORM_URLENCODED)
                .headers(emulateHeaderForProductAndSchema());
        return requestSpecification;

    }

    private static HashMap<String, String> emulateHeaderForProductAndSchema() {
        HashMap<String, String> headersMap = new HashMap<>();
        final String productAndSchema = ConfigQA.getInstance().getParams().getSchema() + "_" + ConfigQA.getInstance().getParams().getProduct();
                switch (productAndSchema) {
                    case ("pro_pro"):
                        headersMap.put("issuer", "https://sso.project.pro");
                        headersMap.put("db_schema", "bc");
                        break;
                    case ("public_projects"):
                        headersMap.put("issuer", "https://sso.projects.ru");
                        headersMap.put("db_schema", "public");
                        break;
                    default: new Exception().printStackTrace();
                }
                return headersMap;
    }

    private static RequestSpecification getBaseRSWithOutLoginAndType() {
        RequestSpecification requestSpecification = given().log().all(true)
                .filter(new AllureFilter())
                .filter(new SwaggerCoverageRestAssured())
                .headers(emulateHeaderForProductAndSchema());
        return requestSpecification;

    }

    private static RequestSpecification getBaseRSWithOutAuth() {
        RequestSpecification requestSpecification = given().log().all(true).filter(new AllureFilter())
                .contentType(APPLICATION_JSON)
                .filter(new SwaggerCoverageRestAssured());
        getHeaderIssuerAndSchema(requestSpecification);
        return requestSpecification;
    }

    private static RequestSpecification getBaseRS(String username) {
        RequestSpecification requestSpecification = given().log().all(true)
                .filter(new AllureFilter())
                .filter(new SwaggerCoverageRestAssured())
                .accept(APPLICATION_JSON)
                .header("Authorization", "Bearer " + TOKENS.get(username));
        getHeaderIssuerAndSchema(requestSpecification);
        return requestSpecification;
    }

    private static RequestSpecification getBaseRSWithContTypeJson(String username) {
        return getBaseRS(username)
                .filter(new AllureFilter())
                .filter(new SwaggerCoverageRestAssured())
                .contentType(APPLICATION_JSON);
    }

    private static RequestSpecification getBaseRSWithoutContTypeJson(String username) {
        return getBaseRS(username)
                .filter(new AllureFilter())
                .filter(new SwaggerCoverageRestAssured());
    }

    private static RequestSpecification getReqSpecWithQueryParamsAndBody(LoginForm loginForm, Map<String, ?> parameters, String bodyJsonString) {
        RequestSpecification requestSpecification = getBaseRS(getLogin(loginForm).getUsername())
                .queryParams(parameters)
                .filter(new AllureFilter())
                .filter(new SwaggerCoverageRestAssured());
        if (bodyJsonString != null) {
            requestSpecification.body(bodyJsonString);
        }
        return requestSpecification;
    }

    private static RequestSpecification getHeaderIssuerAndSchema(RequestSpecification requestSpecification) {
        return requestSpecification.headers(emulateHeaderForProductAndSchema());
    }

    private static MultiPartSpecification getMultipartRS(File file, String mimeType) {
        return new MultiPartSpecBuilder(file).with().mimeType(mimeType).and().with().fileName(file.getName()).build();
    }
}
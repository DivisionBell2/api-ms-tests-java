package ru.projects.orb.api.ca;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.projects.entities.ca.dto.CaWorkflowDTO;
import ru.projects.entities.ca.json.registerrequest.RegisterRequestJson;
import ru.projects.entities.ca.json.registerrequest.RegisterRequestJsonFactory;
import ru.projects.entities.ca.json.registerresponse.RegisterResponseJson;
import ru.projects.entities.orb.json.userdata.UserDataJson;
import ru.projects.helpers.ApiHelper;
import ru.projects.steps.orb.OrbIntegrationSteps;
import ru.yandex.qatools.allure.annotations.Title;

import static java.net.HttpURLConnection.HTTP_OK;
import static ru.projects.helpers.assert_helper.AssertHelper.*;

public class RegisterTest extends CaBaseTest {

    @Title("Registration new user for certificate getting")
    @Test
    public void postRegister() {
        UserDataJson data = OrbIntegrationSteps.createUserRequestForRequest();

        RegisterRequestJson registerRequestJson = RegisterRequestJsonFactory.getRegisterRequestJsonFactory(data);
        Response response = ApiHelper.post(loginForm, "/v1/register", registerRequestJson);
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);

        checkResponseJsonSchema(response, RegisterResponseJson.class);
        CaWorkflowDTO caWorkflowDTO = caController.getById(CaWorkflowDTO.class, response.as(RegisterResponseJson.class).getWorkflowId());
        caWorkflowDTO.compareTo(registerRequestJson);
    }
}
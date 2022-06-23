package ru.projects.orb.api.ca;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.projects.entities.ca.dto.CaWorkflowDTO;
import ru.projects.entities.ca.json.informator.InformatorJson;
import ru.projects.entities.ca.json.informator.InformatorJsonFactory;
import ru.projects.helpers.ApiHelper;
import ru.yandex.qatools.allure.annotations.Title;

import static java.net.HttpURLConnection.HTTP_OK;
import static ru.projects.helpers.assert_helper.AssertHelper.*;

public class InformatorTest extends CaBaseTest {

    @Title("Call user to tell code")
    @Test
    public void getVoiceCodeInformator() {
        CaWorkflowDTO db = caController.getByTypeWf("identification");
        Response response = ApiHelper.getByPath(loginForm, "" + db.getCustomerId());
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);
        checkResponseJsonSchema(response, InformatorJson.class);
        Assert.assertEquals(response.getBody().jsonPath().getObject("", InformatorJson.class), InformatorJsonFactory.getInformatorJson());
    }
}

package ru.projects.orb.api.orb.request;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.projects.entities.orb.dto.dataRequests.OrbDataRequestsDTO;
import ru.projects.entities.orb.json.RequestByTypeJson;
import ru.projects.enums.orb.RequestTypes;
import ru.projects.helpers.assert_helper.AssertHelper;
import ru.projects.orb.api.orb.UniRboBaseTest;
import ru.projects.steps.orb.OrbRequestSteps;
import ru.projects.steps.orb.testData.OrbTestData;
import ru.projects.steps.orb.testData.OrbTestDataFactory;
import ru.yandex.qatools.allure.annotations.Title;

public class RequestTypesTest extends UniRboBaseTest {

    @Title("Getting ENTREPRENEUR request by type")
    @Test
    public void getEntrepreneurRequestByType() {
        getRequestByType(RequestTypes.ENTREPRENEUR);
    }

    @Title("Getting LEGAL ENTITY request by type")
    @Test
    public void getLegalEntityRequestByType() {
        getRequestByType(RequestTypes.LEGAL_ENTITY);
    }

    private void getRequestByType(RequestTypes type) {
        OrbTestData testData = OrbTestDataFactory.getNewUserInfo();
        OrbDataRequestsDTO rboidosDataRequestsDTO = orbController.getById(
                OrbDataRequestsDTO.class,
                OrbRequestSteps.postCreateNewRequest(testData.getLoginForm(), type).getBody().jsonPath().getLong("id")
        );
        String requestType = rboidosDataRequestsDTO.getType();
        Response response = OrbRequestSteps.getRequestByType(testData.getLoginForm(), requestType);

        AssertHelper.checkResponseJsonSchema(response, RequestByTypeJson.class);
        rboidosDataRequestsDTO.compareTo(response.then().extract().body().as(RequestByTypeJson.class));
    }
}

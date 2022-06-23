package ru.projects.orb.api.orb.request;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.projects.entities.orb.dto.OrbBankEmployeesDTO;
import ru.projects.entities.orb.dto.dataRequests.OrbDataRequestsDTO;
import ru.projects.entities.orb.dto.dataRequests.OrbDataRequestsFactory;
import ru.projects.entities.orb.json.RequestByTypeJson;
import ru.projects.enums.orb.RequestTypes;
import ru.projects.orb.api.orb.UniRboBaseTest;
import ru.projects.steps.orb.OrbRequestSteps;
import ru.projects.steps.orb.testData.OrbTestData;
import ru.projects.steps.orb.testData.OrbTestDataFactory;
import ru.yandex.qatools.allure.annotations.Title;

import static ru.projects.helpers.assert_helper.AssertHelper.assertEquals;
import static ru.projects.helpers.assert_helper.AssertHelper.checkResponseJsonSchema;

public class CreateNewRequestTest extends UniRboBaseTest {

    @Title("Creating legal entity reqeust")
    @Test
    public void createLLCrequest() {
        createNewRequest(RequestTypes.LEGAL_ENTITY);
    }

    @Title("Creating entrepreneur reqeust")
    @Test
    public void createIPrequest() {
        createNewRequest(RequestTypes.ENTREPRENEUR);
    }

    @Title("Create entrepreneur request with agent")
    @Test
    public void putCreateEntrepreneurRequestWithAgent() {
        createNewRequestWithAgent(RequestTypes.ENTREPRENEUR);
    }

    @Title("Create legal entity request with agent")
    @Test
    public void putCreateLLCRequestWithAgent() {
        createNewRequestWithAgent(RequestTypes.LEGAL_ENTITY);
    }

    private void createNewRequest(RequestTypes type) {
        OrbTestData testData = OrbTestDataFactory.getNewUserInfo();
        Response response = OrbRequestSteps.postCreateNewRequest(testData.getLoginForm(), type);
        RequestByTypeJson requestByType = response.as(RequestByTypeJson.class);
        OrbDataRequestsDTO db = orbController.getById(OrbDataRequestsDTO.class, requestByType.getId());

        checkResponseJsonSchema(response, RequestByTypeJson.class);
        db.compareTo(OrbDataRequestsFactory.getDataRequests(requestByType));
    }

    private void createNewRequestWithAgent(RequestTypes type) {
        OrbTestData testData = OrbTestDataFactory.getNewRequest(type);
        OrbBankEmployeesDTO orbBankEmployeesDTO = orbController.getLast(OrbBankEmployeesDTO.class);
        long agentNumber = orbBankEmployeesDTO.getPersonnelNumber();
        OrbRequestSteps.putCreateRequestWithAgent(testData.getLoginForm(), testData.getRequestId(), agentNumber);
        OrbDataRequestsDTO requestDTO = orbController.getById(OrbDataRequestsDTO.class, Long.parseLong(testData.getRequestId()));
        assertEquals(requestDTO.getRboidosRequestsEmployeesRelations().iterator().next().getId(), orbBankEmployeesDTO.getId());
    }
}
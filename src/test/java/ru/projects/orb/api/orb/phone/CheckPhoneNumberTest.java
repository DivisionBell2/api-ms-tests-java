package ru.projects.orb.api.orb.phone;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.projects.entities.orb.json.error.ErrorJson;
import ru.projects.entities.orb.json.error.ErrorItemJson;
import ru.projects.enums.orb.ErrorCodes;
import ru.projects.enums.orb.RequestTypes;
import ru.projects.helpers.ApiHelper;
import ru.projects.helpers.assert_helper.AssertHelper;
import ru.projects.orb.api.orb.UniRboBaseTest;
import ru.projects.steps.orb.OrbPhoneSteps;
import ru.projects.steps.orb.OrbRequestSteps;
import ru.projects.steps.orb.testData.OrbTestData;
import ru.projects.steps.orb.testData.OrbTestDataFactory;
import ru.yandex.qatools.allure.annotations.Title;

public class CheckPhoneNumberTest extends UniRboBaseTest {

    @Title("Check valid phone number for entrepreneur request")
    @Test
    public void checkingValidPhoneCodeEntrepreneur() {
        OrbTestData testData = OrbTestDataFactory.getNewUserInfo();
        checkValidPhoneCodeAndReturnRequestId(testData, RequestTypes.ENTREPRENEUR);
    }

    @Title("Check valid phone number for legal entity request")
    @Test
    public void checkingValidPhoneCodeLegalEntity() {
        OrbTestData testData = OrbTestDataFactory.getNewUserInfo();
        checkValidPhoneCodeAndReturnRequestId(testData, RequestTypes.LEGAL_ENTITY);
    }

    @Title("Check double valid phone number for entrepreneur request (negative)")
    @Test
    public void checkingValidPhoneDobuledCodeEntrepreneur() {
        OrbTestData testData = OrbTestDataFactory.getNewUserInfo();
        checkErrorInfo(testData, checkValidPhoneCodeAndReturnRequestId(testData, RequestTypes.ENTREPRENEUR));
    }

    @Title("Check double valid phone number for legal entity request (negative)")
    @Test
    public void checkingValidPhoneDoubledCodeLegalEntity() {
        OrbTestData testData = OrbTestDataFactory.getNewUserInfo();
        checkErrorInfo(testData, checkValidPhoneCodeAndReturnRequestId(testData, RequestTypes.LEGAL_ENTITY));
    }

    private String checkValidPhoneCodeAndReturnRequestId(OrbTestData testData, RequestTypes type) {
        String id = OrbRequestSteps.postCreateNewRequest(testData.getLoginForm(), type).getBody().jsonPath().getString("id");
        OrbPhoneSteps.getValidationPhoneNumber(testData.getLoginForm(), id, testData.getUserORB().getPhone());

        return id;
    }

    private void checkErrorInfo(OrbTestData testData, String id) {
        String path = "/v1/request/" + id + "/user/phone/" + testData.getUserORB().getPhone() + "/code";
        Response response = ApiHelper.getByPathAndValue(testData.getLoginForm(), path, "");

        AssertHelper.assertStatus(response, 499);
        AssertHelper.checkResponseJsonSchema(response, ErrorJson.class);
        ErrorItemJson error = response.as(ErrorJson.class).getErrors().get(0);
        AssertHelper.assertEquals(error.getError(), "Операция недопустима: Повторная отправка будет доступна через 15 секунд");
        AssertHelper.assertEquals(error.getCode(), ErrorCodes.PROHIBITED_OPERATION.name());
    }
}

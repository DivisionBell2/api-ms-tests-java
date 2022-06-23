package ru.projects.orb.api.orb.phone;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.projects.enums.orb.RequestTypes;
import ru.projects.helpers.assert_helper.AssertHelper;
import ru.projects.orb.api.orb.UniRboBaseTest;
import ru.projects.steps.orb.OrbPhoneSteps;
import ru.projects.steps.orb.OrbRequestSteps;
import ru.projects.steps.orb.testData.OrbTestData;
import ru.projects.steps.orb.testData.OrbTestDataFactory;
import ru.yandex.qatools.allure.annotations.Title;

public class CheckPhoneValidatedTest extends UniRboBaseTest {

    @Title("Check phone validation for entreprenur request")
    @Test
    public void postEntrepreneurCheckPhoneValidated() {
        checkPhoneValidated(RequestTypes.ENTREPRENEUR);
    }

    @Title("Check phone validation for legal entity request")
    @Test
    public void postLegalEntityCheckPhoneValidated() {
        checkPhoneValidated(RequestTypes.LEGAL_ENTITY);
    }

    @Title("Check phone is not validated for entreprenur request")
    @Test
    public void postEntrepreneurCheckPhoneNotValidated() {
        checkPhoneNotValidated(RequestTypes.ENTREPRENEUR);
    }

    @Title("Check phone is not validated for legal entity request")
    @Test
    public void postLegalEntityCheckPhoneNotValidated() {
        checkPhoneNotValidated(RequestTypes.LEGAL_ENTITY);
    }

    private void checkPhoneValidated(RequestTypes type) {
        OrbTestData testData = OrbTestDataFactory.getNewUserInfo();
        String id = OrbRequestSteps.postCreateNewRequest(testData.getLoginForm(), type).getBody().jsonPath().getString("id");

        OrbPhoneSteps.getValidationPhoneNumber(testData.getLoginForm(), id, testData.getUserORB().getPhone());

        Response response = OrbPhoneSteps.getIsPhoneValidated(testData.getLoginForm(), id, testData.getUserORB().getPhone());
        AssertHelper.assertTrue(Boolean.parseBoolean(response.getBody().asString()), "Phone validated");
    }

    private void checkPhoneNotValidated(RequestTypes type) {
        OrbTestData testData = OrbTestDataFactory.getNewUserInfo();
        String id = OrbRequestSteps.postCreateNewRequest(testData.getLoginForm(), type).getBody().jsonPath().getString("id");

        Response response = OrbPhoneSteps.getIsPhoneValidated(testData.getLoginForm(), id, testData.getUserORB().getPhone());
        AssertHelper.assertFalse(Boolean.parseBoolean(response.getBody().asString()), "Phone is not validated");
    }
}

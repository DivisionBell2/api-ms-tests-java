package ru.projects.orb.api.orb.phone;

import org.testng.annotations.Test;
import ru.projects.entities.orb.dto.dataRequests.OrbDataRequestsDTO;
import ru.projects.enums.orb.RequestStates;
import ru.projects.enums.orb.RequestTypes;
import ru.projects.helpers.assert_helper.AssertHelper;
import ru.projects.orb.api.orb.UniRboBaseTest;
import ru.projects.steps.orb.testData.OrbTestData;
import ru.projects.steps.orb.testData.OrbTestDataFactory;
import ru.yandex.qatools.allure.annotations.Title;

public class ValidationPhoneTest extends UniRboBaseTest {

    @Title("Phone validation for entreprenur request")
    @Test
    public void postEntrepreneurValidationPhone() {
        postValidationPhone(RequestTypes.ENTREPRENEUR);
    }

    @Title("Phone validation for legal entity request")
    @Test
    public void postLegalEntityValidationPhone() {
        postValidationPhone(RequestTypes.LEGAL_ENTITY);
    }

    private void postValidationPhone(RequestTypes type) {
        OrbTestData testData = OrbTestDataFactory.getNewRequest(type);
        AssertHelper.assertEquals(RequestStates.PHONE_VALIDATED.name(),
                orbController.getById(OrbDataRequestsDTO.class, Long.parseLong(testData.getRequestId())).getState());
    }
}
package ru.projects.steps.orb.testData;

import ru.projects.entities.auth.LoginForm;
import ru.projects.entities.core.router.v2.userRBO.UserORB;
import ru.projects.enums.orb.RequestTypes;
import ru.projects.enums.orb.UserRegistrationSources;
import ru.projects.steps.UserDataSteps;
import ru.projects.steps.orb.OrbPhoneSteps;
import ru.projects.steps.orb.OrbRequestSteps;

public class OrbTestDataFactory {

    public static OrbTestData getNewUserInfo() {
        OrbTestData testData = new OrbTestData();
        UserORB userORB = UserDataSteps.registerNewORBUser(UserRegistrationSources.ORB.name());
        testData.setUserORB(userORB);
        testData.setLoginForm(new LoginForm(true, userORB.getEmail(), userORB.getPassword()));
        return testData;

    }

    public static OrbTestData getNewRequest(RequestTypes type) {
        OrbTestData testData = getNewUserInfo();

        String id = OrbRequestSteps.postCreateNewRequest(testData.getLoginForm(), type).getBody().jsonPath().getString("id");
        OrbPhoneSteps.getValidationPhoneNumber(testData.getLoginForm(), id, testData.getUserORB().getPhone());

        testData.setRequestId(id);

        return testData;

    }
}
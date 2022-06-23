package ru.projects.steps;

import io.restassured.response.Response;
import ru.projects.ConfigQA;
import ru.projects.dictionary.Service;
import ru.projects.entities.auth.AuthUserData;
import ru.projects.entities.core.router.v2.userRBO.UserORB;
import ru.projects.entities.core.router.v2.userRBO.UserORBFactory;
import ru.projects.helpers.ApiHelper;
import ru.projects.providers.EntityProvider;
import ru.yandex.qatools.allure.annotations.Step;

import static java.net.HttpURLConnection.HTTP_OK;
import static ru.projects.helpers.assert_helper.AssertHelper.*;

public class UserDataSteps {
    private static final String COURE_ROUTER_URI = ConfigQA.getInstance().getServiceUrl(Service.ROUTER);
    private static EntityProvider<AuthUserData> authUserDataEntityProvider = new EntityProvider<>(AuthUserData.class);

    @Step("Sending ORB register request")
    public synchronized static UserORB registerNewORBUser(String path) {
        UserORB user = UserORBFactory.getRandoumUserORBWithPhone();
        Response response = ApiHelper.post(COURE_ROUTER_URI + "" + path, user.toJsonString());
        user.setId(response.getBody().jsonPath().getLong("id"));
        assertStatus(response, HTTP_OK);
        assertJsonIsValid(response);
        return user;
    }


}
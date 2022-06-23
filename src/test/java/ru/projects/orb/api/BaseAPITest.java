package ru.projects.orb.api;

import com.typesafe.config.ConfigFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import ru.projects.ConfigQA;
import ru.projects.dictionary.Service;
import ru.projects.entities.auth.AuthUserData;
import ru.projects.entities.auth.LoginForm;
import ru.projects.helpers.ApiHelper;
import ru.projects.providers.EntityProvider;
import ru.yandex.qatools.allure.annotations.Step;

import static ru.projects.helpers.assert_helper.AssertHelper.checkResponse;
import static ru.projects.helpers.assert_helper.AssertHelper.checkResponseCode;

public abstract class BaseAPITest {
  protected LoginForm commonLoginForm;
  protected AuthUserData userData;
  protected Boolean isBcSchema;

  public static String setUri(String uri) {
    return uri;
  }

  @BeforeSuite
  public void initService() {
    RestAssured.useRelaxedHTTPSValidation();
  }

  @BeforeClass
  public void initParams() {
    isBcSchema = ConfigQA.getInstance().getParams().isBcSchema();
    commonLoginForm = new LoginForm(true, ConfigQA.getInstance().getParams().getAdminUserName(),
        ConfigQA.getInstance().getParams().getAdminUserPass());
    userData = new EntityProvider<>(AuthUserData.class)
            .getById(isBcSchema ? 909844 : ConfigFactory.parseResources("config_dasreda.conf").getLong("dasreda.AdminUserID"));
  }

  @BeforeClass
  public void setBaseURI() {
    RestAssured.baseURI = setUri(ConfigQA.getInstance().getServiceUrl(getServiceApi()));
    if (!ConfigQA.getInstance().getParams().getProduct().equals("neo")) {
      getSmoke();
    }
  }

  @Step
  public void getSmoke() {
    System.out.print(
        "Try smoke on - " + ConfigQA.getInstance().getServiceDbName(getServiceApi()) + " with url "
            + RestAssured.baseURI);
    Response response = ApiHelper.getByPath(null, "");
    System.out.println("Response: " + response.asString());
    System.out.println("Status code: " + response.statusCode());
    checkResponseCode(response, HttpStatus.SC_OK);
  }

  protected abstract Service getServiceApi();
}
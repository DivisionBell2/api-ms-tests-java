package ru.projects.orb.api.orb.address;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.project.entities.orbCommon.json.address.AddressJson;
import ru.projects.helpers.assert_helper.AssertHelper;
import ru.projects.orb.api.orb.UniRboBaseTest;
import ru.projects.steps.orb.OrbDataSteps;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.UnsupportedEncodingException;

public class AddressHintsTest extends UniRboBaseTest {

    @Title("Getting Address hints")
    @Test
    public void getAddressHints() throws UnsupportedEncodingException {
        Response response = OrbDataSteps.getAddressHints(null, ADDRESS_NAME);
        AssertHelper.checkResponseJsonSchema(response, AddressJson[].class);
    }
}

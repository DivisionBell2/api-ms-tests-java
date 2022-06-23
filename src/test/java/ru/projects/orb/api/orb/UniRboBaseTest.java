package ru.projects.orb.api.orb;

import org.testng.annotations.BeforeClass;
import ru.projects.dictionary.Service;
import ru.projects.orb.api.BaseAPITest;
import ru.projects.providers.controller.uni.OrbController;

public abstract class UniRboBaseTest extends BaseAPITest {
    protected Service getServiceApi() {
        return Service.OBR;
    }

    protected OrbController orbController;

    protected static final String ADDRESS_NAME = "Санкт-Петербург Энгельса 3";

    @BeforeClass
    public void initController() {
        orbController = OrbController.getInstance();
    }
}
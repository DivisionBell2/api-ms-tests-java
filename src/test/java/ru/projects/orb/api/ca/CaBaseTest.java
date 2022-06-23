package ru.projects.orb.api.ca;

import org.testng.annotations.BeforeClass;
import ru.projects.entities.auth.LoginForm;
import ru.projects.providers.controller.uni.CaController;

public class CaBaseTest {

    protected CaController caController;
    protected LoginForm loginForm;

    @BeforeClass
    public void initController() {
        caController = CaController.getInstance();
    }
}

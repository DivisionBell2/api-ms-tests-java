package ru.projects.steps.orb.testData;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.projects.entities.auth.LoginForm;
import ru.projects.entities.core.router.v2.userRBO.UserORB;
import ru.projects.entities.orb.json.userdata.UserDataJson;

@NoArgsConstructor
@Data
public class OrbTestData {
    private UserORB userORB;
    private LoginForm loginForm;
    private String requestId;
    private UserDataJson userData;
}

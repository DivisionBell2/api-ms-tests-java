package ru.projects.entities.core;

import lombok.Getter;
import lombok.Setter;

public class UserRoles {
    @Getter
    @Setter
    private int userId;
    @Getter
    @Setter
    private int companyId;
    @Getter
    @Setter
    private boolean active;
    @Getter
    @Setter
    private int userCompanyId;

    public UserRoles(int userIdParam, int companyIdParam, Boolean activeParam, int userCompanyIdParam) {
        userId = userIdParam;
        companyId = userCompanyIdParam;
        active = activeParam;
        userCompanyId = userCompanyIdParam;
    }
}

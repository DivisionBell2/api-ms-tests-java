package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

public class UserToCompanyRole extends EntityData {
    @Getter @Setter private long userId;
    @Getter @Setter private long companyId;
    @Getter @Setter private long occupationId;
    @Getter @Setter private long regionId;
    @Getter @Setter private long moduleId;
    @Getter @Setter private String moduleName;

    public UserToCompanyRole() {
    }

    public UserToCompanyRole(long userId, long companyId, long occupationId, long regionId, long moduleId, String moduleName) {
        this.userId = userId;
        this.companyId = companyId;
        this.occupationId = occupationId;
        this.regionId = regionId;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
    }

    @Override
    public String toString() {
        return "UserToCompanyRole{"
                + "userId=" + userId
                + ", companyId=" + companyId
                + ", occupationId=" + occupationId
                + ", regionId=" + regionId
                + ", moduleId=" + moduleId
                + ", moduleName='" + moduleName + '\''
                + '}';
    }
}
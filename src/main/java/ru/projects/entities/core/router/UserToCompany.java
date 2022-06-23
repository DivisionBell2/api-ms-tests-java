package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

public class UserToCompany extends EntityData {
    @Getter @Setter private long userId;
    @Getter @Setter private long companyId;
    @Getter @Setter private long[] occupationId;
    @Getter @Setter private long regionId;

    public UserToCompany() {
    }

    public UserToCompany(long userId, long companyId, long[] occupationId, long regionId) {
        this.userId = userId;
        this.companyId = companyId;
        this.occupationId = occupationId;
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "UserToCompany{"
                + "userId=" + userId
                + ", companyId=" + companyId
                + ", occupationId=" + occupationId
                + ", regionId=" + regionId
                + '}';
    }
}

package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import java.util.List;

public class UserCompanyInfo extends EntityData {
    @Getter @Setter private long ssoId;
    @Getter @Setter private String name;
    @Getter @Setter private List<CompanyInfoData> companies;

    public UserCompanyInfo() {
    }

    public UserCompanyInfo(long ssoId, String name, List<CompanyInfoData> companies) {
        this.ssoId = ssoId;
        this.name = name;
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "UserCompanyInfo{"
                + super.toString()
                + "ssoId=" + ssoId
                + ", name='" + name + '\''
                + ", companies=" + companies
                + '}';
    }
}
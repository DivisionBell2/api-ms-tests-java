package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

public class CompanyInfoData extends EntityData {
    @Getter @Setter private String companyName;
    @Getter @Setter private OccupationData userOccupation;
    @Getter @Setter private CompanySizeData companySize;
    @Getter @Setter private CompanyBusinessData companyBusiness;
    @Getter @Setter private CompanyIndustryData companyIndustry;
    @Getter @Setter private CompanyActivityData companyActivity;

    public CompanyInfoData() {
    }

    public CompanyInfoData(String companyName, OccupationData userOccupation, CompanySizeData companySize,
                           CompanyBusinessData companyBusiness, CompanyIndustryData companyIndustry, CompanyActivityData companyActivity) {
        this.companyName = companyName;
        this.userOccupation = userOccupation;
        this.companySize = companySize;
        this.companyBusiness = companyBusiness;
        this.companyIndustry = companyIndustry;
        this.companyActivity = companyActivity;
    }

    @Override
    public String toString() {
        return "CompanyInfoData{"
                + super.toString()
                + "companyName='" + companyName + '\''
                + ", userOccupation=" + userOccupation
                + ", companySize=" + companySize
                + ", companyBusiness=" + companyBusiness
                + ", companyIndustry=" + companyIndustry
                + ", companyActivity=" + companyActivity
                + '}';
    }
}
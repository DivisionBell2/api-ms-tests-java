
package ru.projects.entities.core.router;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {

    public long id;
    public String name;
    public boolean attitudeActive;
    public boolean admin;
    public CompanySizeData companySize;
    public CompanyBusinessData companyBusiness;
    public CompanyIndustryData companyIndustry;
    public CompanyActivityData companyActivity;

}

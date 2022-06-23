package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "general_dict_company_industry", schema = "CoreRouter")
public class CompanyIndustryData extends EntityData {

    @Column(name = "name")
    @Getter @Setter private String name;

    public CompanyIndustryData() {
    }

    public CompanyIndustryData(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompanyIndustryData{"
                + super.toString()
                + "name='" + name + '\''
                + '}';
    }
}

package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "general_dict_company_business", schema = "CoreRouter")
public class CompanyBusinessData extends EntityData {

    @Column(name = "name")
    @Getter @Setter private String name;

    public CompanyBusinessData() {
    }

    public CompanyBusinessData(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompanyBusinessData{"
                + super.toString()
                + "name='" + name + '\''
                + '}';
    }
}

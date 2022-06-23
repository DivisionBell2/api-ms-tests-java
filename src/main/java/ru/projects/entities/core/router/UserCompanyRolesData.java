package ru.projects.entities.core.router;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class UserCompanyRolesData {

    @Getter @Setter
    private int moduleId;

    @Getter
    @Setter private String moduleName;

    @Getter @Setter private RelationData relation;

    public UserCompanyRolesData() {

    }

    public UserCompanyRolesData(int moduleId, String moduleName, RelationData relation) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.relation = relation;
    }
}

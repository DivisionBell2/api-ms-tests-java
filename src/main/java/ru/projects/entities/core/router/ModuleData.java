package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@Table(name = "general_list_modules", schema = "router")
public class ModuleData extends EntityData {
    @Column(name = "name")
    @Getter @Setter private String name;

    public ModuleData() {
    }

    public ModuleData(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ModuleData{"
                + super.toString()
                + "name='" + name + '\''
                + '}';
    }
}

package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "general_list_bustypes", schema = "CoreRouter")
public class BusTypeData extends EntityData {

    @Column(name = "name")
    @Getter @Setter private String name;

    public BusTypeData() {
    }

    public BusTypeData(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BusTypeData{"
                + super.toString()
                + "name='" + name + '\''
                + "}";
    }
}

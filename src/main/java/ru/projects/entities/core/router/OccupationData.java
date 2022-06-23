package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "general_dict_occupation", schema = "CoreRouter")
public class OccupationData extends EntityData {

    @Column(name = "name")
    @Getter @Setter private String name;

    public OccupationData() {
    }

    public OccupationData(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OccupationData{"
                + super.toString()
                + "name='" + name + '\''
                + '}';
    }
}

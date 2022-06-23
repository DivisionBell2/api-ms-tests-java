package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "general_dict_region", schema = "CoreRouter")
public class RegionData extends EntityData {

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "code")
    @Getter @Setter private long code;

    public RegionData() {
    }

    public RegionData(String name, long code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return "RegionData{"
                + super.toString()
                + "name='" + name + '\''
                + ", code=" + code
                + '}';
    }
}

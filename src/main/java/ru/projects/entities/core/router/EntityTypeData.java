package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "general_list_entity_types", schema = "CoreRouter")
public class EntityTypeData extends EntityData {

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "microservice_id")
    @Getter @Setter private long microserviceId;

    @Column(name = "is_trusted")
    @Getter @Setter private boolean trusted;

    public EntityTypeData() {
    }

    public EntityTypeData(String name, long microserviceId, boolean trusted) {
        this.name = name;
        this.microserviceId = microserviceId;
        this.trusted = trusted;
    }

    @Override
    public String toString() {
        return "EntityTypeData{"
                + super.toString()
                + "name='" + name + '\''
                + ", microserviceId=" + microserviceId
                + ", trusted=" + trusted
                + '}';
    }
}
package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class CoordinatesData extends EntityData {

    @Getter @Setter private int microserviceId;

    @Getter @Setter private int entityTypeId;

    @Getter @Setter private int itemId;

    public CoordinatesData() {
    }

    public CoordinatesData(int microserviceId, int entityTypeId, int itemId) {
        this.microserviceId = microserviceId;
        this.entityTypeId = entityTypeId;
        this.itemId = itemId;
    }
}

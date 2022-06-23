package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class CoordonatesListDto extends EntityData {

    @Getter @Setter private List<CoordinatesData> coordinates;

    public CoordonatesListDto() {
    }

    public CoordonatesListDto(List<CoordinatesData> coordinates) {
        this.coordinates = coordinates;
    }

}

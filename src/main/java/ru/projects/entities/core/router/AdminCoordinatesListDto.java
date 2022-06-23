package ru.projects.entities.core.router;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class AdminCoordinatesListDto extends CoordonatesListDto {

    @Getter
    @Setter
    private List<Integer> modStates;

    public AdminCoordinatesListDto(List<Integer> modStates) {
        this.modStates = modStates;
    }

    public AdminCoordinatesListDto(List<CoordinatesData> coordinates, List<Integer> modStates) {
        super(coordinates);
        this.modStates = modStates;
    }

    public List<Integer> getModStates() {
        return modStates;
    }

    public void setModStates(List<Integer> modStates) {
        this.modStates = modStates;
    }
}

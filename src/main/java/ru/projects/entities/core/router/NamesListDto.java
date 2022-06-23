package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class NamesListDto extends EntityData {

    @Getter @Setter private List<String> names;
    @Getter @Setter private int pageSize;
    @Getter @Setter private int page;
    @Getter @Setter private boolean meta;

    public NamesListDto() {
    }

    public NamesListDto(List<String> names, int pageSize, int page, boolean meta) {
        this.names = names;
        this.pageSize = pageSize;
        this.page = page;
        this.meta = meta;
    }
}

package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "general_list_taxestypes", schema = "CoreRouter")
public class TaxesTypeData extends EntityData {
    @Column(name = "name")
    @Getter @Setter private String name;

    @Override
    public String toString() {
        return "TaxesTypeData{"
                + super.toString()
                + "name='" + name + '\''
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxesTypeData that = (TaxesTypeData) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
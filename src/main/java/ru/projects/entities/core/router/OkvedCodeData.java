package ru.projects.entities.core.router;

import lombok.*;
import ru.projects.entities.EntityData;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "general_list_okveds", schema = "CoreRouter")
public class OkvedCodeData extends EntityData {
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OkvedCodeData that = (OkvedCodeData) o;
        return Objects.equals(name, that.name)
                && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }
}
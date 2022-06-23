package ru.projects.entities.core.router.v2;

import lombok.*;
import ru.projects.entities.EntityData;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oauth20_partners")
public class OAuth20PartnerDTO   {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "secret")
    private String secret;

    @Column(name = "description")
    private String description;
    @Column(name = "support_implicit")
    private  Boolean supportImplicit;
    @Column(name = "grants")
    private  Integer   grants;
    @Column(name = "response_types")
    private String responseTypes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityData that = (EntityData) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

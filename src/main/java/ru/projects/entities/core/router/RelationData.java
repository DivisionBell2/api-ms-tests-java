package ru.projects.entities.core.router;

import lombok.*;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "general_ref_users_companies", schema = "CoreRouter")
public class RelationData extends EntityData {

    @Column(name = "id_user")
    @Getter @Setter
    private int userId;

    @Column(name = "id_company")
    @Getter
    @Setter private int companyId;

    @Column(name = "is_active")
    @Getter @Setter private boolean active;

    @Column(name = "is_active")
    @Getter @Setter private boolean isAdmin;

    @Override
    public String toString() {
        return "RelationData{"
                + "userId=" + userId
                + ", companyId=" + companyId
                + ", active=" + active
                + '}';
    }
}

package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "general_users_invite", schema = "CoreRouter")
public class InviteData extends EntityData {

    @Column(name = "email")
    @Getter @Setter private String email;

    @Getter @Setter private Boolean accepted;

    @Column(name = "exp_data")
    @Getter @Setter private String createdAt;

    @Column(name = "id_company")
    @Getter @Setter private int companyId;

    public InviteData() {

    }

    public InviteData(String email, Boolean accepted, String createdAt, int companyId) {
        this.email = email;
        this.accepted = accepted;
        this.createdAt = createdAt;
        this.companyId = companyId;
    }
}

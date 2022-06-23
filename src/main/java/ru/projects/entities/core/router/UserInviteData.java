package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "general_users_invite", schema = "CoreRouter")
public class UserInviteData extends EntityData {

    @Column(name = "id")
    @Getter @Setter private long userId;

    @Column(name = "email")
    @Getter @Setter private String email;

    @Column(name = "invite_token")
    @Getter @Setter private String inviteToken;

    @Column(name = "id_company")
    @Getter @Setter private long companyId;

    @Column(name = "exp_date")
    @Getter @Setter private String expDate;

    public UserInviteData() {
    }

    public UserInviteData(long userId, String email, String inviteToken, long companyId, String expDate) {
        this.userId = userId;
        this.email = email;
        this.inviteToken = inviteToken;
        this.companyId = companyId;
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "UserInviteData{"
                + super.toString()
                + "userId=" + userId
                + ", email='" + email + '\''
                + ", inviteToken='" + inviteToken + '\''
                + ", companyId=" + companyId
                + ", expDate='" + expDate + '\''
                + '}';
    }
}

package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

public class EmailInviteData extends EntityData {
    @Getter @Setter private String email;
    @Getter @Setter private long companyId;

    public EmailInviteData(String email, long companyId) {
        this.email = email;
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "EmailInviteData{"
                + "email='" + email + '\''
                + ", companyId=" + companyId
                + '}';
    }
}

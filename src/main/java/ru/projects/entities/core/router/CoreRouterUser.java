package ru.projects.entities.core.router;

import lombok.Getter;
import lombok.Setter;
import ru.projects.entities.EntityData;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import java.util.List;

@Entity
@Table(name = "general_data_users", schema = "CoreRouter")
public class CoreRouterUser extends EntityData {

    @Getter @Setter private long dataId;
    @Null
    @Getter @Setter private String phone;
    @Getter @Setter private boolean active;
    @Getter @Setter private String username;
    @Getter @Setter private String firstName;
    @Null
    @Getter @Setter private String lastName;
    @Null
    @Getter @Setter private String middleName;
    @Getter @Setter private String app;
    @Getter @Setter private String password;
    @Getter @Setter private List<String> apps;
    @Getter @Setter private List<String> roles;

    public CoreRouterUser() {
    }

    public CoreRouterUser(long dataId, @Null String phone, boolean active, String username, String firstName, String lastName,
                          String middleName, String app, String password, List<String> apps, List<String> roles) {
        this.dataId = dataId;
        this.phone = phone;
        this.active = active;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.app = app;
        this.password = password;
        this.apps = apps;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "CoreRouterUser{"
                + "dataId=" + dataId
                + ", phone='" + phone + '\''
                + ", active=" + active
                + ", username='" + username + '\''
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", middleName='" + middleName + '\''
                + ", app='" + app + '\''
                + ", password='" + password + '\''
                + ", apps=" + apps
                + ", roles=" + roles
                + '}';
    }
}
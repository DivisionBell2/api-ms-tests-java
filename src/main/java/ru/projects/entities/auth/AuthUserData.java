package ru.projects.entities.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@NoArgsConstructor
@Table(name = "users", schema = "Auth")
public class AuthUserData extends EntityData {

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    @Null
    private String lastName;
    @Null
    @Column(name = "middle_name")
    private String middleName;
    @Null
    @Column(name = "phone")
    private String phone;
    @Null
    @Column(name = "masked_email")
    private String maskedEmail;
    @Null
    @Column(name = "is_active")
    private boolean active;

    private List<String> roles;

    private List<String> apps;
    @Null
    private String avatarUrl;
    @Null
    private String region;
    @Null
    private String description;
    @Null
    private String city;
    @Null
    private String biology;
    @Null
    private String custom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUserData that = (AuthUserData) o;
        return active == that.active
                && Objects.equals(username, that.username)
                && Objects.equals(String.valueOf(firstName).trim(), String.valueOf(that.firstName).trim())
                && Objects.equals(String.valueOf(lastName).trim(), String.valueOf(that.lastName).trim())
                && Objects.equals(String.valueOf(middleName).trim(), String.valueOf(that.middleName).trim())
                && Objects.equals(String.valueOf(phone), String.valueOf(that.phone))
                && Objects.equals(roles, that.roles)
                && Objects.equals(apps, that.apps)
                && Objects.equals(String.valueOf(avatarUrl), String.valueOf(that.avatarUrl))
                && Objects.equals(String.valueOf(region), String.valueOf(that.region))
                && Objects.equals(String.valueOf(description), String.valueOf(that.description))
                && Objects.equals(String.valueOf(biology), String.valueOf(that.biology));
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName, middleName, phone, active, roles, apps, avatarUrl, region,
                description, city, biology, custom);
    }

    @Override
    public String toString() {
        return "AuthUserData{"
                + "username='" + username + '\''
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", middleName='" + middleName + '\''
                + ", phone='" + phone + '\''
                + ", apps=" + apps
                + ", role=" + roles
                + '}';
    }
}

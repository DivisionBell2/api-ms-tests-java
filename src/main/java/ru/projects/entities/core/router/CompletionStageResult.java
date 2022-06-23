package ru.projects.entities.core.router;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class CompletionStageResult extends EntityData {

    @JsonIgnore
    @Getter @Setter private  String phone;
    @Getter @Setter private String username;

    @JsonIgnore
    @Getter @Setter private String lastName;
    @JsonIgnore
    @Getter @Setter private String firstName;

    @JsonIgnore
    @Getter @Setter private  String middleName;
    @Getter @Setter private boolean active;
    @Getter @Setter private List<String> apps;
    @Getter @Setter private List<String> roles;

    @JsonIgnore
    @Getter @Setter private String avatarUrl;

    @JsonIgnore
    @Getter @Setter private String region;

    @JsonIgnore
    @Getter @Setter private String description;

    @JsonIgnore
    @Getter @Setter private String city;

    @JsonIgnore
    @Getter @Setter private String custom;

    public CompletionStageResult() {
    }

    public CompletionStageResult(String phone, String username, String lastName, String firstName, String middleName,
                                 boolean active, List<String> apps, List<String> roles, String avatarUrl, String region,
                                 String description, String city, String custom) {
        this.phone = phone;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.active = active;
        this.apps = apps;
        this.roles = roles;
        this.avatarUrl = avatarUrl;
        this.region = region;
        this.description = description;
        this.city = city;
        this.custom = custom;
    }
}

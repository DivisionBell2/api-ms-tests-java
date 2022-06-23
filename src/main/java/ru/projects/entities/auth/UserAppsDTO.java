package ru.projects.entities.auth;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Data
@Table(name = "users_to_apps")
public class UserAppsDTO {
    @Id
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "app_id")
    private Long appId;
    @Column(name = "role_name")
    private String role;

    public UserAppsDTO(Long userId, String role) {
        this.userId = userId;
        this.role = role;
    }
}

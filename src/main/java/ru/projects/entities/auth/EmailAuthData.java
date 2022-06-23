package ru.projects.entities.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "email_auth_data")
public class EmailAuthData {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "email")
    private String email;

    @Column(name = "is_active")
    private Boolean isActive;
    @Null
    @Column(name = "used_at")
    private String usedAt;
}


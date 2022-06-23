package ru.projects.entities.core.router.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@NoArgsConstructor
@Table(name = "user_back_actions")
public class UserBackActionsDto implements Serializable {

    @Id
    @Column(name = "user_id")
    public Long userId;

    @Id
    @Column(name = "login_type")
    public String loginType;

    @Id
    @Column(name = "indate")
    public String indate;

    @Id
    @Column(name = "confirmed")
    public Boolean confirmed;

    @Null
    @Id
    @Column(name = "confirm_date")
    public String confirmDate;

    @Id
    @Column(name = "code")
    public String code;

    @Id
    @Column(name = "action_type")
    public String actionType;
}

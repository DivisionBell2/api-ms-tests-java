package ru.projects.entities.core.router.v2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_agreements")
public class UserAgreementsV2 {
    @Id
    @Null
    @Column(name = "type")
    public String type;

    @Column(name = "user_id")
    public Long userId;

    @Column(name = "indate")
    public String indate;

    @Column(name = "agreed")
    public Boolean agreed;

    @Column(name = "docdate")
    public String docdate;

}

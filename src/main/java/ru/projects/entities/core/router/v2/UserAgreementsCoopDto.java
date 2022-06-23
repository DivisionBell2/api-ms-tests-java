package ru.projects.entities.core.router.v2;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_agreements")
public class UserAgreementsCoopDto implements Comparable<UserAgreementsCoopDto>, Serializable {

    @Id
    @Column(name = "type")
    public String type;

    @Id
    @Column(name = "user_id")
    public long userId;

    @Id
    @Column(name = "indate")
    public String indate;

    @Id
    @Column(name = "agreed")
    public boolean agreed;

    @Id
    @Null
    @Column(name = "docdate")
    public String docDate;

    @Override
    public int compareTo(UserAgreementsCoopDto agr) {
        return this.getType().compareTo(agr.getType());
    }
}

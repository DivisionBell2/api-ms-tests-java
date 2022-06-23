package ru.projects.entities.core.router;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_agreements")
public class UserAgreementsDto {
    @Id
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "type")
    private String type;
    @Column(name = "agreed")
    private Boolean agreed;
    @Column(name = "indate")
    private String indate;
    @Column(name = "docdate")
    private String docdate;
}

package ru.projects.entities.core.router;

import lombok.*;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "general_dict_company_activity", schema = "CoreRouter")
public class CompanyActivityData extends EntityData {

    @Column(name = "name")
    private String name;

}

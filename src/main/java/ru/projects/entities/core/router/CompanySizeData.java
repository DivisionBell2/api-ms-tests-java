package ru.projects.entities.core.router;

import lombok.*;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "general_dict_company_size", schema = "CoreRouter")
public class CompanySizeData extends EntityData {

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Override
    public String toString() {
        return "CompanySizeData{"
               + super.toString()
               + "name='" + name + '\''
               + '}';
    }
}

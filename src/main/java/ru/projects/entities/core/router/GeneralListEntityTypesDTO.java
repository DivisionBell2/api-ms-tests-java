package ru.projects.entities.core.router;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "general_list_entity_types", schema = "CoreRouter")
public class GeneralListEntityTypesDTO extends EntityData {

   @Column(name  = "microservice_id")
   private long microserviceId;
   @Column(name  = "name")
   private String name;
   @Column(name  = "is_trusted")
   private String isTrusted;

}

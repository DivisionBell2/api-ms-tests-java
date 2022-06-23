package ru.projects.entities.core.router;


import lombok.*;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "general_data_user_pass_changes", schema = "CoreRouter")
public class GeneralDataUserPassChangesDTO extends EntityData {

   @Column(name  = "accepted")
   private String accepted;
   @Column(name  = "created_at")
   private java.sql.Timestamp createdAt;
   @Column(name  = "email")
   private String email;
   @Column(name  = "uuid")
   private String uuid;

}

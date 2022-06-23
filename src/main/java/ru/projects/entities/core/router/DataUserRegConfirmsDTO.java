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
@Table(name = "general_data_user_reg_confirms", schema = "CoreRouter")
public class DataUserRegConfirmsDTO extends EntityData {

   @Column(name  = "accepted")
   private boolean accepted;
   @Column(name  = "created_at")
   private String createdAt;
   @Column(name  = "email")
   private String email;
   @Column(name  = "uuid")
   private String uuid;
   @Column(name  = "user_data")
   private String userData;
   @Column(name  = "dispatch_agree")
   private String dispatchAgree;

}

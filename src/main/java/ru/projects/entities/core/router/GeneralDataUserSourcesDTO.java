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
@Table(name = "general_data_user_sources", schema = "CoreRouter")
public class GeneralDataUserSourcesDTO extends EntityData {

   @Column(name  = "email")
   private String email;
   @Column(name  = "indate")
   private java.sql.Timestamp indate;
   @Column(name  = "channel_id")
   private String channelId;
   @Column(name  = "sso_id")
   private long ssoId;

}

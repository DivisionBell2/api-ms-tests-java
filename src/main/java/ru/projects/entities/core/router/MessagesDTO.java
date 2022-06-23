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
@Table(name = "general_data_user_messages", schema = "CoreRouter")
public class MessagesDTO extends EntityData {

   @Column(name  = "sender_id")
   private long senderId;
   @Column(name  = "receiver_id")
   private long receiverId;
   @Column(name  = "0message")
   private String message;

}

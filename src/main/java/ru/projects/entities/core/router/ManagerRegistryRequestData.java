package ru.projects.entities.core.router;

import lombok.Getter;
import lombok.Setter;
import ru.projects.entities.EntityData;

import javax.persistence.Entity;

@Entity
public class ManagerRegistryRequestData extends EntityData {

     @Getter @Setter private String phone;
     @Getter @Setter private String username;
     @Getter @Setter private String inn;
     @Getter @Setter private String lastName;
     @Getter @Setter private String firstName;
     @Getter @Setter private String middleName;
     @Getter @Setter private boolean dispatchAgree;

    public ManagerRegistryRequestData() {
    }

    public ManagerRegistryRequestData(String phone, String username, String inn, String lastName, String firstName,
                                      String middleName, boolean dispatchAgree) {
        this.phone = phone;
        this.username = username;
        this.inn = inn;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dispatchAgree = dispatchAgree;
    }
}

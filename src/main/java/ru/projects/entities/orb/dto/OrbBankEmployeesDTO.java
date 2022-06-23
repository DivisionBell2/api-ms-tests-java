package ru.projects.entities.orb.dto;

import lombok.*;
import ru.projects.entities.EntityData;
import ru.projects.entities.orb.dto.dataRequests.OrbDataRequestsDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "orb_bank_employees")
public class OrbBankEmployeesDTO extends EntityData {
    @Column(name = "personnel_number")
    private Long personnelNumber;

    @Column(name = "remote_id")
    private String remoteId;

    @Column(name = "pos_id")
    private String posId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    private String description;

    private Boolean archived;

    private Long version;

    private String created;

    private String updated;

    @ManyToMany(mappedBy = "orbRequestsEmployeesRelations", cascade = CascadeType.ALL)
    private Set<OrbDataRequestsDTO> rboidosRequestsEmployeesRelations;
}

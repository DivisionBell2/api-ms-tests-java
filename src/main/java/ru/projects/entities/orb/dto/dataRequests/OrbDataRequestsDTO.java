package ru.projects.entities.orb.dto.dataRequests;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.Assert;
import ru.projects.entities.EntityData;
import ru.projects.entities.orb.dto.OrbBankEmployeesDTO;
import ru.projects.entities.orb.json.RequestByTypeJson;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orb_data_requests")
public class OrbDataRequestsDTO extends EntityData {
    @Column(name = "id_user")
    private Long idUser;
    private String created;
    private String updated;
    private String state;
    private String type;
    @Column(name = "vsp_code")
    private String vspCode;
    @Column(name = "tariff_code")
    private String tariffCode;
    private Integer attempts;
    @Column(name = "open_account_container_uuid")
    private String openAccountContainerUUID;
    private Boolean archived;
    @Column(name = "next_process_time")
    private String nextProcessTime;
    private String initialized;
    @Column(name = "fns_request_id")
    private Long fnsRequestID;
    @Column(name = "fns_request_container_uuid")
    private String fnsRequestContainerUUID;
    @Column(name = "certificate_issuing_count")
    private Integer certificateIssuingCount;
    private Long version;
    @Column(name = "onsite_office_id")
    private Long onsiteOfficeID;
    private Boolean suspended;
    @Column(name = "using_sberbank_account_opening_api_v2")
    private Boolean usingSberbankAccountOpeningAPIv2;
    private String channel;
    @Null
    @Column(name = "onsite_city_id")
    private Long onsiteCity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rboidos_requests_employees_relations",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<OrbBankEmployeesDTO> rboidosRequestsEmployeesRelations;

    public void compareTo(OrbDataRequestsDTO expectedRequestInfo) {
        Assert.assertEquals(getChannel(), expectedRequestInfo.getChannel());
        Assert.assertEquals(getId(), expectedRequestInfo.getId());
        Assert.assertEquals(getState(), expectedRequestInfo.getState());
        Assert.assertEquals(getType(), expectedRequestInfo.getType());
        Assert.assertEquals(getOnsiteCity(), expectedRequestInfo.getOnsiteCity());
        Assert.assertEquals(getOnsiteOfficeID(), expectedRequestInfo.getOnsiteOfficeID());
        Assert.assertEquals(getTariffCode(), expectedRequestInfo.getTariffCode());
        Assert.assertEquals(getVspCode(), expectedRequestInfo.getVspCode());
    }

    public void compareTo(RequestByTypeJson expectedRequestByType) {
        Assert.assertEquals(getChannel(), expectedRequestByType.getChannel().toString());
        Assert.assertEquals(getState(), expectedRequestByType.getState().toString());
        Assert.assertEquals(getType(), expectedRequestByType.getType().toString());
    }
}

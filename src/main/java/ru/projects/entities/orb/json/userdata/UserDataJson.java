package ru.projects.entities.orb.json.userdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.Builder;
import lombok.Data;
import ru.project.entities.orbCommon.json.address.AddressJson;

import javax.validation.constraints.Null;

@Data
@Builder
public class UserDataJson {
    private AddressJson address;
    private String birthDate;
    private String birthPlace;
    @Null
    private String compliancePassed;
    @Null
    private String contactPhone;
    private String email;
    private String firstName;
    private Boolean flComplianceRuned;
    private Boolean flComplianceSuccess;
    private String inn;
    private String lastName;
    private String middleName;
    @Null
    private String partner;
    private String passportGivenBy;
    private String passportGivenDate;
    private String passportGivenDept;
    private String passportNumber;
    private String passportSeria;
    @Null
    private String phone;
    @Null
    private String phoneAttached;
    private String registryAddress;
    private Boolean sbolValidated;
    private Boolean sexMale;
    private String snils;
    private Long ssoId;
    private String created;
    private Long requestId;
    private Long addressId;
    private Long version;
    private Boolean userContactPhoneForDos;
    private Boolean phoneValidated;
    @Null
    @JsonSchema(required = true)
    private String founderInfo;
    @Null
    @JsonSchema(required = true)
    private String hideFounderInfo;
    @Null
    @JsonSchema(required = true)
    private String passportValidDate;
    @Null
    @JsonProperty(required = true)
    private String active;
}

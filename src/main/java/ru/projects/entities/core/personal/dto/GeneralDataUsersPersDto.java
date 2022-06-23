package ru.projects.entities.core.personal.dto;

import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.projects.entities.EntityData;
import ru.projects.entities.core.router.v2.userRBO.UserORB;
import ru.projects.entities.orb.json.fio.FioJson;
import ru.projects.entities.orb.json.fldata.FLDataJson;
import ru.projects.entities.orb.json.userdata.UserDataJson;
import ru.projects.helpers.assert_helper.AssertHelper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Data
@NoArgsConstructor
@Table(name = "general_data_users_pers")
public class GeneralDataUsersPersDto extends EntityData {

    @Null
    @JsonSchema(required = true)
    @Column(name = "passport_seria")
    private String passportSeria;
    @Null
    @JsonSchema(required = true)
    @Column(name = "passport_num")
    private String passportNumber;
    @Null
    @JsonSchema(required = true)
    @Column(name = "birth_date")
    private String birthDate;
    @Null
    @JsonSchema(required = true)
    @Column(name = "passport_givenby")
    private String passportGivenBy;
    @Null
    @JsonSchema(required = true)
    @Column(name = "passport_given_dept")
    private String passportGivenDept;
    @Null
    @JsonSchema(required = true)
    @Column(name = "passport_given_date")
    private String passportGivenDate;
    @Null
    @JsonSchema(required = true)
    @Column(name = "registry_address")
    private String registryAddress;
    @Null
    @JsonSchema(required = true)
    @Column(name = "inn")
    private String inn;
    @Null
    @JsonSchema(required = true)
    @Column(name = "snils")
    private String snils;
    @Null
    @JsonSchema(required = true)
    @Column(name = "sber_id")
    private String sberId;
    @Null
    @JsonSchema(required = true)
    @Column(name = "first_name")
    private String firstName;
    @Null
    @JsonSchema(required = true)
    @Column(name = "last_name")
    private String lastName;
    @Null
    @JsonSchema(required = true)
    @Column(name = "middle_name")
    private String middleName;
    @Null
    @JsonSchema(required = true)
    @Column(name = "birth_place")
    private String birthPlace;
    @Null
    @JsonSchema(required = true)
    @Column(name = "sex_male")
    private Boolean sexMale;

/*
    @Null
    @Column(name = "locked")
    private boolean locked;*/
    @Null
    @JsonSchema(required = true)
    @Column(name = "email")
    private String email;
    @Null
    @JsonSchema(required = true)
    @Column(name = "phone")
    private String phone;

    @Null
    @JsonSchema(required = true)
    @Column(name = "link_scan_passport1")
    private String linkScanPassport1;

    @Null
    @JsonSchema(required = true)
    @Column(name = "link_scan_passport2")
    private String linkScanPassport2;
    @Null
    @JsonSchema(required = true)
    @Column(name = "link_scan_snils")
    private String linkScanSnils;

    @Null
    @JsonSchema(required = true)
    @Column(name = "has_company")
    private Boolean hasCompany;

    @Null
    @JsonSchema(required = true)
    @Column(name = "home_address")
    private String homeAddress;

    @Null
    @JsonSchema(required = true)
    @Column(name = "home_phone")
    private String homePhone;

    public void compareTo(UserDataJson userData) {
        AssertHelper.assertEquals(this.getFirstName(), userData.getFirstName());
        AssertHelper.assertEquals(this.getMiddleName(), userData.getMiddleName());
        AssertHelper.assertEquals(this.getLastName(), userData.getLastName());
        AssertHelper.assertEquals(this.getPassportSeria(), userData.getPassportSeria());
        AssertHelper.assertEquals(this.getPassportNumber(), userData.getPassportNumber());
        AssertHelper.assertEquals(this.getPassportGivenBy(), userData.getPassportGivenBy());
        AssertHelper.assertContains(this.getPassportGivenDate(), userData.getPassportGivenDate());
        AssertHelper.assertEquals(this.getPassportGivenDept(), userData.getPassportGivenDept());
        AssertHelper.assertEquals(this.getRegistryAddress(), userData.getRegistryAddress());
        AssertHelper.assertEquals(this.getInn(), userData.getInn());
        AssertHelper.assertEquals(this.getSnils(), userData.getSnils());
        AssertHelper.assertContains(this.getBirthDate(), userData.getBirthDate());
        AssertHelper.assertEquals(this.getBirthPlace(), userData.getBirthPlace());
        AssertHelper.assertEquals(this.getSexMale(), userData.getSexMale());
        AssertHelper.assertEquals(this.getEmail(), userData.getEmail());
        AssertHelper.assertEquals(this.getPhone(), userData.getPhone());
    }

    public void compareTo(FLDataJson userData) {
        AssertHelper.assertEquals(this.getFirstName(), userData.getFirstName());
        AssertHelper.assertEquals(this.getMiddleName(), userData.getMiddleName());
        AssertHelper.assertEquals(this.getLastName(), userData.getLastName());
        AssertHelper.assertEquals(this.getPassportSeria(), userData.getPassportSeria());
        AssertHelper.assertEquals(this.getPassportNumber(), userData.getPassportNumber());
        AssertHelper.assertEquals(this.getPassportGivenBy(), userData.getPassportGivenBy());
        AssertHelper.assertContains(this.getPassportGivenDate(), userData.getPassportGivenDate());
        AssertHelper.assertEquals(this.getPassportGivenDept(), userData.getPassportGivenDept());
        AssertHelper.assertEquals(this.getRegistryAddress(), userData.getRegistryAddress());
        AssertHelper.assertEquals(this.getInn(), userData.getInn());
        AssertHelper.assertEquals(this.getSnils(), userData.getSnils());
        AssertHelper.assertContains(this.getBirthDate(), userData.getBirthDate());
        AssertHelper.assertEquals(this.getBirthPlace(), userData.getBirthPlace());
        AssertHelper.assertEquals(this.getSexMale(), userData.getSexMale());
        AssertHelper.assertEquals(this.getEmail(), userData.getEmail());
        AssertHelper.assertEquals(this.getPhone(), userData.getPhone());
    }

    public void compareTo(FioJson fio) {
        AssertHelper.assertEquals(this.getFirstName(), fio.getFirstName());
        AssertHelper.assertEquals(this.getMiddleName(), fio.getMiddleName());
        AssertHelper.assertEquals(this.getLastName(), fio.getLastName());
    }

    public void compareTo(UserORB user) {
        AssertHelper.assertEquals(this.getFirstName(), user.getFirstName());
        AssertHelper.assertEquals(this.getMiddleName(), user.getMiddleName());
        AssertHelper.assertEquals(this.getLastName(), user.getLastName());
        AssertHelper.assertEquals(this.getEmail(), user.getEmail());
    }

    public void compareTo(GeneralDataUsersPersDto user) {
        AssertHelper.assertEquals(this.getFirstName(), user.getFirstName());
        AssertHelper.assertEquals(this.getMiddleName(), user.getMiddleName());
        AssertHelper.assertEquals(this.getLastName(), user.getLastName());
        AssertHelper.assertEquals(this.getEmail(), user.getEmail());
        AssertHelper.assertEquals(this.getPhone(), user.getPhone());
        AssertHelper.assertEquals(this.getInn(), user.getInn());
    }
}

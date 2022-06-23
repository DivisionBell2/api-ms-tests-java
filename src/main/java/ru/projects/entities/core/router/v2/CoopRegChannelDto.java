package ru.projects.entities.core.router.v2;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@NoArgsConstructor
@Table(name = "reg_channels", schema = "public")
public class CoopRegChannelDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "email_confirm_code_mask")
    private String emailConfirmCodeMask;
    @Column(name = "phone_confirm_code_mask")
    private String phoneConfirmCodeMask;
    @Column(name = "password_mask")
    private String passwordMask;
    @Column(name = "password_reqs")
    private String passwordReqs;
    @Column(name = "require_name")
    private Boolean requireName;
    @Column(name = "require_inn")
    private Boolean requireInn;
    @Column(name = "require_phone")
    private Boolean requirePhone;
    @Column(name = "registry_confirm")
    private Boolean registryConfirm;
    @Column(name = "notify_by_phone")
    private Boolean notifyByPhone;
    @Column(name = "notify_by_email")
    private Boolean notifyByEmail;
    @Column(name = "welcome_by_phone")
    private Boolean welcomeByPhone;
    @Column(name = "welcome_by_email")
    private Boolean welcomeByEmail;
    @Column(name = "email_login_if_exist")
    private Boolean emailLoginIfExist;
    @Column(name = "phone_login_if_exist")
    private Boolean phoneLoginIfExist;
    @Column(name = "require_email")
    private Boolean requireEmail;
    @Column(name = "allow_apps_roles_set")
    private Boolean allowAppsRolesSet;
    @Column(name = "external_password")
    private Boolean externalPassword;
    @Column(name = "delivery_transit")
    private Boolean deliveryTransit;
    @Column(name = "disabled")
    private Boolean disabled;
    @Column(name = "welcome_email_template_id")
    private String welcomeEmailTemplateId;
    @Column(name = "registry_email_template_id")
    private String registryEmailTemplateId;
    @Column(name = "change_password_email_template_id")
    private String changePasswordEmailTemplateId;
    @Column(name = "welcome_email_template_slug")
    private String welcomeEmailTemplateSlug;
    @Column(name = "registry_email_template_slug")
    private String registryEmailTemplateSlug;
    @Column(name = "change_password_email_template_slug")
    private String changePasswordEmailTemplateSlug;
    @Column(name = "registry_phone_template")
    private String registryPhoneTemplate;
    @Column(name = "welcome_phone_template")
    private String welcomePhoneTemplate;
    @Column(name = "change_password_phone_template")
    private String changePasswordPhoneTemplate;
    @Column(name = "registry_sms_repeat_limit")
    private Integer registrySmsRepeatLimit;
    @Column(name = "welcome_sms_repeat_limit")
    private Integer welcomeSmsRepeatLimit;
    @Column(name = "registry_sms_repeat_timeout")
    private Integer registrySmsRepeatTimeout;
    @Column(name = "welcome_sms_repeat_timeout")
    private Integer welcomeSmsRepeatTimeout;
    @Column(name = "msp_interaction")
    private Boolean mspInteraction;
    @Column(name = "direct_change_password_sms_template")
    private String directChangePasswordSmsTemplate;
    @Column(name = "direct_change_password_email_template")
    private String directChangePasswordEmailTemplate;
    @Column(name = "user_deleted_email_template")
    private String userDeletedEmailTemplate;
    @Column(name = "user_deleted_phone_template")
    private String userDeletedPhoneTemplate;
    @Null
    @Column(name = "default_roles")
    private String defaultRoles;
}
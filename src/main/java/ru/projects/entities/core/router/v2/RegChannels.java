package ru.projects.entities.core.router.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@NoArgsConstructor
@Table(name = "reg_channels")
public class RegChannels extends EntityData {
    @Column(name = "email_confirm_code_mask")
    public String emailConfirmCodeMask;
    @Column(name = "phone_confirm_code_mask")
    public String phoneConfirmCodeMask;
    @Column(name = "password_mask")
    public String passwordMask;
    @Column(name = "password_reqs")
    public String passwordRegs;
    @Column(name = "require_name")
    public String requireName;
    @Column(name = "require_inn")
    public String requireInn;
    @Column(name = "require_phone")
    public String requirePhone;
    @Column(name = "registry_confirm")
    public String registryConfirm;
    @Column(name = "notify_by_phone")
    public String notifyByPhone;
    @Column(name = "notify_by_email")
    public String notifyByEmail;
    @Column(name = "welcome_by_phone")
    public String welcomeToPhone;
    @Column(name = "welcome_by_email")
    public String welcomeByEmail;
    @Column(name = "email_login_if_exist")
    public String emailLoginIfExist;
    @Column(name = "phone_login_if_exist")
    public String phoneLoginIfExist;
    @Column(name = "require_email")
    public String requireEmail;
    @Column(name = "allow_apps_roles_set")
    public String allowAppsRolesSet;
    @Column(name = "external_password")
    public String externalPassword;
    @Column(name = "delivery_transit")
    public String deliveryTransit;
    @Column(name = "disabled")
    public boolean disabled;
    @Column(name = "welcome_email_template_id")
    public String welcomeEmailTemplateId;
    @Column(name = "registry_email_template_id")
    public String registryEmailTemplateId;
    @Column(name = "change_password_email_template_id")
    public String changePasswordEmailTemplateId;
    @Column(name = "welcome_email_template_slug")
    public String welcomeEmailTemplateSlug;
    @Column(name = "registry_email_template_slug")
    public String registryEmailTemplateSlug;
    @Column(name = "change_password_email_template_slug")
    public String changePasswordEmailTemplateSlug;
    @Column(name = "registry_phone_template")
    public String registryPhoneTemplate;
    @Column(name = "welcome_phone_template")
    public String welcomePhoneTemplate;
    @Column(name = "change_password_phone_template")
    public String changePasswordPhoneTemplate;
    @Column(name = "registry_sms_repeat_limit")
    public String registrySmsRepeatLimit;
    @Column(name = "welcome_sms_repeat_limit")
    public String welcomeSmsRepeatLimit;
    @Column(name = "registry_sms_repeat_timeout")
    public String registrySmsRepeatTimeout;
    @Column(name = "welcome_sms_repeat_timeout")
    public String welcomeSmsRepeatTimeout;
    @Column(name = "msp_interaction")
    public String mspInteraction;
    @Column(name = "user_deleted_email_template")
    public String userDeletedEmailTemplate;
    @Column(name = "user_deleted_phone_template")
    public String userDeletedPhoneTemplate;
    @Null
    @Column(name = "default_roles")
    public String defaultRoles;
}

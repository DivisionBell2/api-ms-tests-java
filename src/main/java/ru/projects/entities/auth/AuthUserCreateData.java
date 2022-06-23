package ru.projects.entities.auth;


import lombok.Getter;
import lombok.Setter;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static ru.projects.entities.auth.Auth.generateSignature;

@Entity
public class AuthUserCreateData extends EntityData {

    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String firstName = null;

    @Getter
    @Setter
    private String lastName = null;

    @Getter
    @Setter
    private String middleName = null;

    @Getter
    @Setter
    private String phone = null;

    @Getter
    @Setter
    @Column(name = "is_active")
    private Boolean isActive = Boolean.FALSE;

    @Getter
    @Setter
    private String app;

    @Getter
    @Setter
    private String requestId;

    @Getter
    @Setter
    private String signature;

    public AuthUserCreateData() {
    }

    public AuthUserCreateData(String appParam, String passwordParam) {
        setApp(appParam);
        setUsername();
        setPassword(passwordParam);
        Map<String, String> auth = generateSignature();
        this.requestId = auth.get("requestId");
        this.signature = auth.get("signature");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        int rand = ThreadLocalRandom.current().nextInt(1, 1002);
        this.username = "test_" + Integer.toString(rand) + "@dasreda.ru";
    }

    public void updateSignature() {
        Map<String, String> auth = generateSignature();
        this.requestId = auth.get("requestId");
        this.signature = auth.get("signature");
    }

    @Override
    public String toString() {
        return "\nUserData{"
                + "username='" + username
                + '}';
    }
}

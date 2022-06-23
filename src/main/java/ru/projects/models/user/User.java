package ru.projects.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    @Getter @Setter private long id;
    @Getter @Setter private String email;
    @Getter @Setter private String password;
    @Getter @Setter private String firstName;
    @Getter @Setter private String middleName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String phone;
    @Getter @Setter private String inn;
    @JsonIgnore
    @Getter @Setter private  List<JSONObject>  agreements;
    @Getter @Setter private List<String> apps = new ArrayList<>();
    @Getter @Setter private List<String> roles = new ArrayList<>();

    public enum MailSite {
        GOOGLE,
        YANDEX
    }

    @JsonIgnore
    public String toJsonString() {
        Map<String, Object> testData = new HashMap<>();
        testData.put("email", email);
        if (password.length() > 0)
            testData.put("password", password);
        if (firstName.length() > 0)
            testData.put("firstName", firstName);
        if (lastName.length() > 0)
            testData.put("lastName", lastName);
        if (middleName.length() > 0)
            testData.put("middleName", middleName);
        if (phone != null && phone.length() > 0)
            testData.put("phone", phone);
        if (inn != null && inn.length() > 0)
            testData.put("inn", inn);
        if (agreements != null && agreements.size() > 0)
            testData.put("agreements", agreements);
        return new Gson().toJson(testData);
    }

    @JsonIgnore
    public String toJsonStringForCoop() {
        Map<String, Object> testData = new HashMap<>();
        testData.put("email", email);
            testData.put("password", password);
            testData.put("firstName", firstName);
            testData.put("lastName", lastName);
            testData.put("middleName", middleName);
            testData.put("phone", phone);
            testData.put("inn", inn);
            testData.put("roles", roles);
        return new Gson().toJson(testData);
    }
}



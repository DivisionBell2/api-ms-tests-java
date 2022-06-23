package ru.projects.entities.core.router.v2.userRBO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class UserORB {

    @JsonProperty(required = true)
    private String custom;
    @JsonProperty(required = true)
    private String referrer;
    @JsonProperty(required = true, value = "start_url")
    private String startUrl;
    @JsonProperty(required = true)
    private String email;
    @JsonProperty(required = true)
    private String password;
    @JsonProperty(required = true)
    private String firstName;
    @JsonProperty(required = true)
    private String middleName;
    @JsonProperty(required = true)
    private String lastName;
    @JsonProperty(required = true)
    private String username;
    @JsonProperty(required = true)
    private long id;
    @JsonProperty(required = true)
    private String phone;

    public String toJsonString() {

        Map<String, Object> testData = new HashMap<>();
        testData.put("custom", custom);
        testData.put("referrer", referrer);
        testData.put("firstName", firstName);
        testData.put("lastName", lastName);
        testData.put("username", username);
        testData.put("email", email);
        testData.put("phone", phone);

        if (password.length() > 0)
            testData.put("password", password);

        if (middleName.length() > 0)
            testData.put("middleName", middleName);

        return new Gson().toJson(testData);
    }
}

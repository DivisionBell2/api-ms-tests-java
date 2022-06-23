package ru.projects.entities.core.router.v2.userRBO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.Null;
import java.util.List;

@Getter
public class UserRBOResponse {

    @Null
    @JsonProperty(required = true)
    private String active;
    @Null
    @JsonProperty(required = true)
    private List<String> apps;
    @Null
    @JsonProperty(required = true)
    private List<String> roles;
    @JsonProperty(required = true)
    private long id;
    @JsonProperty(required = true)
    private String maskedName;
    @JsonProperty(required = true)
    private String maskedEmail;
    @JsonProperty(required = true)
    private String maskedPhone;
    @JsonProperty(required = true)
    private String publicName;
    @JsonProperty(required = true)
    private String publicEmail;
    @JsonProperty(required = true)
    private String publicPhone;
    @JsonProperty(required = true)
    private String referrer;
    @JsonProperty(required = true)
    private String custom;
    @JsonProperty(required = true, value = "start_url")
    private String startUrl;
    @JsonProperty(required = true)
    private String token;
    @JsonProperty(required = true)
    private Boolean justRegistered;
}

package ru.projects.entities.auth;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import ru.projects.entities.core.router.v2.json.RegistrationUserRequestJson;
import ru.projects.models.user.User;

public class LoginForm {
    @Getter
    @Setter
    private boolean setCookie;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    static Gson gson = new Gson();

    public LoginForm() {
    }

    public LoginForm(boolean setCookie, String username, String password) {
        this.setCookie = setCookie;
        this.username = username;
        this.password = password;
    }

    public LoginForm(User user) {
        this.setCookie = true;
        this.username = user.getEmail();
        this.password = user.getPassword();
    }

    public LoginForm(RegistrationUserRequestJson user) {
        this.setCookie = true;
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public LoginForm(boolean setCookie, User user) {
        this.setCookie = setCookie;
        this.username = user.getEmail();
        this.password = user.getPassword();
    }

    @Override
    public String toString() {
        return "LoginForm{"
                + "setCookie=" + setCookie
                + ", username='" + username + '\''
                + ", password='" + password + '\''
                + '}';
    }

    public String toJsonString() {
        return gson.toJson(this);
    }
}
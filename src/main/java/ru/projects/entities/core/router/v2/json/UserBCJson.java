package ru.projects.entities.core.router.v2.json;

import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.Builder;
import lombok.Data;
import ru.projects.entities.IBaseJson;
import ru.projects.models.user.User;
import ru.projects.utils.RandomUtils;

@Data
@Builder
public class UserBCJson implements IBaseJson<User> {
    @JsonSchema(required = true)
    public Long id;
    @JsonSchema(required = true)
    public String email;
    @JsonSchema(required = true)
    public String password;
    @JsonSchema(required = true)
    public String firstName;
    @JsonSchema(required = true)
    public String middleName;
    @JsonSchema(required = true)
    public String lastName;
    @JsonSchema(required = true)
    public String phone;
    @JsonSchema(required = true)
    public String inn;
    @JsonSchema(required = true)
    public String[] roles;
    @JsonSchema(required = true)
    public String token;

    @Override
    public void compareWithDto(User user) {

    }

    public static UserBCJson getUserBC() {
        return UserBCJson.builder()
                .email(RandomUtils.getRandomGoogleEmail())
                .password("123123")
                .firstName(RandomUtils.getRandomFirstName())
                .lastName(RandomUtils.getRandomLastName())
                .middleName(RandomUtils.getRandomMiddleName())
                .phone(RandomUtils.nextPhone())
                .inn(RandomUtils.getRandomINN())
                .roles(new String[]{
                        "b2b.user",
                        "compcabinet.admin",
                        "courses.user",
                        "events.user",
                        "experts.user",
                        "rbo.user",
                        "survey.user",
                        "traject.user",
                        "uni-blog.user",
                        "uni-comments.user",
                        "uni-delivery.user",
                        "uni-payments.user",
                        "uni-ratings.user",
                        "uni-social.user",
                        "uni-storage.user",
                        "uni-video.user"})
                .build();
    }
}

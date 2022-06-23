package ru.projects.models.user;

import com.typesafe.config.Config;
import ru.projects.ConfigQA;
import ru.projects.utils.RandomUtils;

import java.util.ArrayList;

public class UserFactory {

    public static User getRandom() {
        User user = new User();
        user.setEmail(RandomUtils.nextEmail());
        user.setPassword("7jnOqHNa135");
        user.setFirstName(RandomUtils.getRandomFirstName());
        user.setLastName(RandomUtils.getRandomLastName());
        user.setMiddleName(RandomUtils.getRandomMiddleName());
        user.setPhone(RandomUtils.nextPhone());
        user.setInn(String.valueOf(RandomUtils.randInt(100000, 999999)));
        user.setAgreements(new ArrayList<>());
        return user;
    }

    public static User getAdmin() {
        User user = new User();
        user.setId(ConfigQA.getInstance().getParams().getAdminUserId());
        user.setEmail(ConfigQA.getInstance().getParams().getAdminUserName());
        user.setPassword(ConfigQA.getInstance().getParams().getAdminUserPass());
        user.setFirstName("Никанор");
        user.setLastName("Крыжов");
        user.setMiddleName("Миронович");
        user.setInn("874114130085");
        return user;
    }
}

package ru.projects.entities.ca.json.registerrequest;

import ru.projects.entities.ca.json.registerrequest.consumer.ConsumerJsonFactory;
import ru.projects.entities.orb.json.userdata.UserDataJson;
import ru.projects.enums.orb.UserRegistrationSources;
import ru.projects.enums.orb.UserRegistrationTypes;
import ru.projects.utils.RandomUtils;

public class RegisterRequestJsonFactory {

    public static RegisterRequestJson getRegisterRequestJsonFactory(UserDataJson userData) {
        return RegisterRequestJson
                .builder()
                .remotelyIdentification(true)
                .caTransactionId(RandomUtils.getRandomCaTransactionId())
                .queueName("uni-rbo.notify-from-uni-ca.in")
                .registrationType(UserRegistrationTypes.ORB.name())
                .requestId(userData.getRequestId())
                .registrationSource(UserRegistrationSources.ORB.name())
                .consumer(ConsumerJsonFactory.getConsumerJson(userData))
                .build();
    }
}
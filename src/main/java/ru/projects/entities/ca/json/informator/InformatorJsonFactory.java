package ru.projects.entities.ca.json.informator;

public class InformatorJsonFactory {

    public static InformatorJson getInformatorJson() {
        return InformatorJson
                .builder()
                .timeToNextCall(0)
                .stateCall("ok")
                .build();
    }
}

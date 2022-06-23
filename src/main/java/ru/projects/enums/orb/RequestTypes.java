package ru.projects.enums.orb;

public enum RequestTypes {
    ENTREPRENEUR("ENTREPRENEUR"),
    LEGAL_ENTITY("LEGAL_ENTITY");

    private final String requestTypes;

    RequestTypes(String requestTypes) {
        this.requestTypes = requestTypes;
    }


}
package ru.projects.entities.orb.dto.dataRequests;


import ru.projects.entities.orb.json.RequestByTypeJson;

public class OrbDataRequestsFactory {
    public static OrbDataRequestsDTO getDataRequests(RequestByTypeJson requestJson) {
        OrbDataRequestsDTO request = new OrbDataRequestsDTO();

        request.setChannel(requestJson.getChannel().toString());
        request.setId(requestJson.getId());
        request.setState(requestJson.getState().toString());
        request.setType(requestJson.getType().toString());

        return request;
    }
}

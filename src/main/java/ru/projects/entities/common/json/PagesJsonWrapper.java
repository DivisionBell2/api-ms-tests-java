package ru.projects.entities.common.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PagesJsonWrapper {
    @JsonProperty(required = true)
    private Integer page;
    @JsonProperty(required = true)
    private Integer size;
    @JsonProperty(required = true)
    private Integer totalSize;
    @JsonProperty(required = true)
    private List entities;


}

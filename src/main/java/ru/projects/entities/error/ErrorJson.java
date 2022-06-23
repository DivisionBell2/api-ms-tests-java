package ru.projects.entities.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ErrorJson {

  private String timestamp;

  @JsonProperty(required = true)
  private Integer status;

  @JsonProperty(required = true)
  private String error;

  @JsonProperty(required = true)
  private String message;

  private String path;
}
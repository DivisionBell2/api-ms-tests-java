package ru.projects.entities.orb.json.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ErrorItemJson {
	@JsonProperty(required = true)
	private String code;
	@JsonProperty(required = true, value = "_error")
	private String error;
}

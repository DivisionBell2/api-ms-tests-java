package ru.projects.entities.orb.json.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ErrorJson {
	@JsonProperty(required = true)
	private List<ErrorItemJson> errors;
}
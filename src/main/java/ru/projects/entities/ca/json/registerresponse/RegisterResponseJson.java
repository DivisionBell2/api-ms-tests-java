package ru.projects.entities.ca.json.registerresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.Null;

@Getter
public class RegisterResponseJson {

	@JsonProperty(required = true)
	private String state;
	@JsonProperty(required = true)
	private String customer;
	@Null
	@JsonProperty(required = true)
	private String errorDetails;
	@JsonProperty(required = true)
	private long workflowId;
}

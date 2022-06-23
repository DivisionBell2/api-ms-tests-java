package ru.projects.entities.ca.json.inn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InnRequestJson {

	@JsonProperty(required = true)
	private String documentCode;
	@JsonProperty(required = true)
	private String lastName;
	@JsonProperty(required = true)
	private String firstName;
	@JsonProperty(required = true)
	private String birthPlace;
	@JsonProperty(required = true)
	private String documentNumber;
	@JsonProperty(required = true)
	private String middleName;
	@JsonProperty(required = true)
	private String documentGivenDate;
	@JsonProperty(required = true)
	private String birthDate;
}

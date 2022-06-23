package ru.projects.entities.ca.json.registerrequest.consumer.identities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdentitiesJson {

	@JsonProperty(required = true)
	private String number;
	@JsonProperty(required = true)
	private String issuedBy;
	@JsonProperty(required = true)
	private String issueCode;
	@JsonProperty(required = true)
	private String series;
	@JsonProperty(required = true)
	private String type;
	@JsonProperty(required = true)
	private String issued;
}

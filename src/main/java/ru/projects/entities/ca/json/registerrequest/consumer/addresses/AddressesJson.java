package ru.projects.entities.ca.json.registerrequest.consumer.addresses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Null;

@Data
@Builder
public class AddressesJson {

	@JsonProperty(required = true)
	private String city;
	@Null
	@JsonProperty(required = true)
	private String housing;
	@JsonProperty(required = true)
	private String street;
	@Null
	@JsonProperty(required = true)
	private String district;
	@JsonProperty(required = true)
	private String index;
	@JsonProperty(required = true)
	private String type;
	@JsonProperty(required = true)
	private String region;
	@JsonProperty(required = true)
	private String house;
	@Null
	@JsonProperty(required = true)
	private String building;
	@JsonProperty(required = true)
	private String apartment;
}

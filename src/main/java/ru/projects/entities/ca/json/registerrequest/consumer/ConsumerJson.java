package ru.projects.entities.ca.json.registerrequest.consumer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.projects.entities.ca.json.registerrequest.consumer.identities.IdentitiesJson;
import ru.projects.entities.ca.json.registerrequest.consumer.addresses.AddressesJson;

import javax.validation.constraints.Null;
import java.util.List;

@Data
@Builder
public class ConsumerJson {

	@JsonProperty(required = true)
	private List<AddressesJson> addresses;
	@JsonProperty(required = true)
	private String gender;
	@JsonProperty(required = true)
	private String inn;
	@JsonProperty(required = true, value = "last_name")
	private String lastName;
	@JsonProperty(required = true, value = "middle_name")
	private String middleName;
	@JsonProperty(required = true, value = "sso_id")
	private Long ssoId;
	@JsonProperty(required = true)
	private String birthed;
	private List<IdentitiesJson> identities;
	@Null
	@JsonProperty(required = true)
	private String certificates;
	@JsonProperty(required = true)
	private String phone;
	@JsonProperty(required = true)
	private String id;
	@JsonProperty(required = true)
	private String snils;
	@JsonProperty(required = true, value = "first_name")
	private String firstName;
}
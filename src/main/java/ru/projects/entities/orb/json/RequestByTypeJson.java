package ru.projects.entities.orb.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.projects.enums.orb.IdentiticationCodes;
import ru.projects.enums.orb.RequestStates;
import ru.projects.enums.orb.RequestTypes;

import javax.validation.constraints.Null;
import java.util.List;

@Data
public class RequestByTypeJson {
	@JsonProperty(required = true)
	private Boolean archived;
	@Null
	@JsonProperty(required = true)
	private String tariffCode;
	@Null
	@JsonProperty(required = true)
	private String vspCode;
	@Null
	@JsonProperty(required = true)
	private Long onsiteCityId;
	@Null
	@JsonProperty(required = true)
	private String onsiteOfficeId;
	@Null
	@JsonProperty(required = true)
	private String deliveryType;
	@JsonProperty(required = true)
	private IdentiticationCodes channel;
	@JsonProperty(required = true)
	private Long id;
	@JsonProperty(required = true)
	private RequestStates state;
	@JsonProperty(required = true)
	private RequestTypes type;
	@Null
	@JsonProperty(required = true)
	private Boolean allowNewRequest;
	@Null
	@JsonProperty(required = true)
	private String tariffName;
	@Null
	@JsonProperty(required = true)
	private String usingSberbankAccountOpeningAPIv2;
	@Null
	@JsonProperty(required = true)
	private List<Integer> bankExtraProductIds;
}

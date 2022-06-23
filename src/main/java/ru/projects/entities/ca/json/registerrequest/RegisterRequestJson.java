package ru.projects.entities.ca.json.registerrequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.projects.entities.ca.json.registerrequest.consumer.ConsumerJson;

import javax.validation.constraints.Null;

@Data
@Builder
public class RegisterRequestJson {

	private Boolean remotelyIdentification;
	@JsonProperty(required = true)
	private String caTransactionId;
	@JsonProperty(required = true)
	private String queueName;
	@JsonProperty(required = true)
	private String registrationType;
	@JsonProperty(required = true)
	private Long requestId;
	@Null
	@JsonProperty(required = true)
	private String groupId;
	@Null
	@JsonProperty(required = true)
	private String customerId;
	@JsonProperty(required = true)
	private String registrationSource;
	@Null
	@JsonProperty(required = true)
	private String callbackUrl;
	@JsonProperty(required = true)
	private ConsumerJson consumer;
	@Null
	@JsonProperty(required = true)
	private Object entrepreneur;
	@Null
	@JsonProperty(required = true)
	private Object legalEntity;
}

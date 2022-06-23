package ru.projects.entities.ca.json.informator;

import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InformatorJson {
	@JsonSchema(required = true)
	private int timeToNextCall;
	@JsonSchema(required = true)
	private String stateCall;
}


package ru.projects.entities.core.router.v2.json;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationUserAgreementsJson {

    private Boolean agree;

    private String docDate;

    private String type;
}

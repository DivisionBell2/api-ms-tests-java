package ru.projects.entities.core.router.v2.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.Builder;
import lombok.Data;
import ru.projects.entities.core.router.v2.UserAgreementsCoopDto;
import ru.projects.helpers.assert_helper.AssertHelper;

import javax.validation.constraints.Null;

@Data
@Builder
public class UserAgreementsJson implements Comparable<UserAgreementsJson> {

    @JsonSchema(required = true)
    public String type;

    @JsonSchema(required = true)
    @JsonProperty("user_id")
    public long userId;

    @Null
    @JsonSchema(required = true)
    public String indate;

    @JsonSchema(required = true)
    public boolean agreed;

    @Null
    @JsonSchema(required = true)
    public String docDate;

    public void compareWithDto(UserAgreementsCoopDto userAgreement) {
        AssertHelper.assertEquals(this.type, userAgreement.getType());
        AssertHelper.assertEquals(this.agreed, userAgreement.isAgreed());
        if (this.docDate != null && userAgreement.getDocDate() != null) {
            AssertHelper.assertEquals(this.docDate.replace("T", " "), userAgreement.getDocDate());
        }
        if (this.indate != null && userAgreement.getIndate() != null) {
            AssertHelper.assertEquals(this.indate.replace("T", " "), userAgreement.getIndate());
        }
    }

    @Override
    public int compareTo(UserAgreementsJson agr) {
        return this.getType().compareTo(agr.getType());
    }
}
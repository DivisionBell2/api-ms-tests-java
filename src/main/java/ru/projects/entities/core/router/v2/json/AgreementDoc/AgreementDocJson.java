package ru.projects.entities.core.router.v2.json.AgreementDoc;

import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.Builder;
import lombok.Data;
import ru.projects.entities.IBaseJson;
import ru.projects.entities.core.router.v2.AgreementDocDto;
import ru.projects.helpers.assert_helper.AssertHelper;

@Data
@Builder
public class AgreementDocJson implements IBaseJson<AgreementDocDto>, Comparable<AgreementDocJson> {

    @JsonSchema(required = true)
    Long id;

    @JsonSchema(required = true)
    public String agreementType;

    @JsonSchema(required = true)
    public String docDate;

    @JsonSchema(required = true)
    public String type;

    @JsonSchema(required = true)
    public String bucket;

    @JsonSchema(required = true)
    public String uuid;

    @JsonSchema(required = true)
    public String link;

    @Override
    public void compareWithDto(AgreementDocDto agreementDocDto) {
        AssertHelper.assertEquals(this.agreementType, agreementDocDto.getAgreementType());
        AssertHelper.assertEquals(this.docDate.replace("T", " "), agreementDocDto.getDocDate());
        AssertHelper.assertEquals(this.type, agreementDocDto.getType());
        AssertHelper.assertEquals(this.bucket, agreementDocDto.getBucket());
        AssertHelper.assertEquals(this.uuid, agreementDocDto.getUuid());
        AssertHelper.assertEquals(this.link, agreementDocDto.getLink());
    }

    @Override
    public int compareTo(AgreementDocJson o) {
        return (int) (this.getId() - o.getId());
    }
}

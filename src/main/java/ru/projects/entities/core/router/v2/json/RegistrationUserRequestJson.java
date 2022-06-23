
package ru.projects.entities.core.router.v2.json;

import lombok.Builder;
import lombok.Data;
import ru.projects.entities.IBaseJson;
import ru.projects.entities.core.personal.dto.GeneralDataUsersPersDto;
import ru.projects.helpers.assert_helper.AssertHelper;

import java.util.List;

@Data
@Builder
public class RegistrationUserRequestJson implements IBaseJson<GeneralDataUsersPersDto> {

    private Long id;

    private List<RegistrationUserAgreementsJson> agreements;

    private String channelId;

    private String firstName;

    private Boolean isFirstLogin;

    private String lastName;

    private String password;

    private String username;

    private String phone;

    private String inn;

    public void compareWithDto(GeneralDataUsersPersDto personalDto) {
        AssertHelper.assertEquals(this.getFirstName(), personalDto.getFirstName());
        AssertHelper.assertEquals(this.getLastName(), personalDto.getLastName());
        AssertHelper.assertEquals(this.getUsername(), personalDto.getEmail());
        AssertHelper.assertEquals(this.getPhone().replace("+", ""), personalDto.getPhone());
    }
}

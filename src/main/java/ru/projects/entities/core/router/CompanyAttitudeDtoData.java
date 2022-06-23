package ru.projects.entities.core.router;

import lombok.*;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "general_data_user_custom", schema = "CoreRouter")
public class CompanyAttitudeDtoData extends EntityData {

    @Column(name = "user_id")
    private long userId;

    @Column(name = "avatar_url")
    private String avatarUrl;

    private Boolean userIsAdmin;

    private Boolean attitudeAcive;

    @Column(name = "region_id")
    private RegionData userRegion;

    private List<OccupationData> occupations;
}



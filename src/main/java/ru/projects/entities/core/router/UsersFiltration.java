
package ru.projects.entities.core.router;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersFiltration {

    private boolean paged;
    private long pageSize;
    private long pageIndex;
    private List<Long> filterByUserOccupationsIds = null;
    private List<Long> filterByUserRegionsIds = null;
    private List<Long> filterByUsersIds = null;
    private List<Long> filterByCompanyActivitesIds = null;
    private List<Long> filterByCompanySizesIds = null;
    private List<Long> filterByCompanyBusinessesIds = null;
    private List<Long> filterByCompanyIndustriesIds = null;

}

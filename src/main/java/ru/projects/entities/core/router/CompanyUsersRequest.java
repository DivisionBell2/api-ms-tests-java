
package ru.projects.entities.core.router;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CompanyUsersRequest {

    private boolean paged;
    private long pageSize;
    private long pageIndex;
    private long companyId;

}

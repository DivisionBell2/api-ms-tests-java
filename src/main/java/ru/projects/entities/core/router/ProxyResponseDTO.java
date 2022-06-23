
package ru.projects.entities.core.router;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProxyResponseDTO {

    public String method;
    public String url;
    public Object[] payload;

}

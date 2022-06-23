package ru.projects.entities.core.router;

import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "general_list_microservices", schema = "CoreRouter")
public class MicroserviceData extends EntityData {

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "base_url")
    @Getter @Setter private String baseUrl;

    public MicroserviceData() {
    }

    public MicroserviceData(String name, String baseUrl) {
        this.name = name;
        this.baseUrl = baseUrl;
    }

    @Override
    public String toString() {
        return "MicroserviceData{"
                + super.toString()
                + "name='" + name + '\''
                + ", baseUrl='" + baseUrl + '\''
                + '}';
    }
}
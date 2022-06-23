package ru.projects.entities.core.router;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.projects.entities.EntityData; import lombok.Getter; import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Deprecated
@Entity
@Table(name = "general_data_categories", schema = "router")
public class GlobalCategoryData extends EntityData {

    @Column(name = "name")
    @Getter @Setter private String name;

    @JsonIgnore
    @Column(name = "chapter")
    @Getter @Setter private String chapter;

    @Column(name = "codename")
    @Getter @Setter private String codename;

    @JsonIgnore
    @Column(name = "parent_id")
    @Getter @Setter private int parentid;

    public GlobalCategoryData() {
    }

    public GlobalCategoryData(String name, String chapter, String codename) {
        this.name = name;
        this.chapter = chapter;
        this.codename = codename;
    }

    public GlobalCategoryData(String name, String chapter, String codename, int parentid) {
        this.name = name;
        this.chapter = chapter;
        this.codename = codename;
        this.parentid = parentid;
    }
}
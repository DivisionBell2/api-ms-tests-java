package ru.projects.entities.core.router.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@NoArgsConstructor
@Table(name = "user_agreements", schema = "CoreRouter")
public class UserAgreements extends EntityData {

    @Null
    @Column(name = "type")
    public String type;

    @Column(name = "user_id")
    public long userId;

    @Column(name = "indate")
    public String indate;

    @Column(name = "agreed")
    public boolean agreed;

    @JsonIgnore
    public UserAgreements(String type, Boolean agreed) {
        this.type = type;
        this.agreed = agreed;
    }

    @JsonIgnore
    public JSONObject getJSON() {
        JSONObject rt = new JSONObject();
        rt.put("type", type);
        rt.put("agree", agreed);
      return rt;
    }
}

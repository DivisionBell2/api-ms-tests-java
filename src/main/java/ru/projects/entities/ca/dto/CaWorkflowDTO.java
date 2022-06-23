package ru.projects.entities.ca.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.projects.entities.EntityData;
import ru.projects.entities.ca.json.registerrequest.RegisterRequestJson;
import ru.projects.helpers.assert_helper.AssertHelper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ca_workflow")
public class CaWorkflowDTO extends EntityData {
    @Column(name = "type_wf")
    private String typeWf;
    private String state;
    private String created;
    private String updated;
    private Long scenario;
    @Column(name = "consumer_type")
    private String consumerType;
    @Column(name = "customer_id")
    private String customerId;

    public void compareTo(RegisterRequestJson registerRequestJson) {
        AssertHelper.assertEquals(this.getScenario(), 87L);
        AssertHelper.assertEquals(this.getConsumerType(), "natural_entity");
    }
}

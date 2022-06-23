package ru.projects.entities.core.router.v2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.projects.entities.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agreement_document")
public class AgreementDocDto extends EntityData implements Comparable<AgreementDocDto> {

    @Column(name = "agreement_type")
    public String agreementType;

    @Column(name = "docdate")
    public String docDate;

    @Column(name = "type")
    public String type;

    @Column(name = "bucket")
    public String bucket;

    @Column(name = "uuid")
    public String uuid;

    @Column(name = "link")
    public String link;

    @Override
    public int compareTo(AgreementDocDto o) {
       return (int) (this.getId() - o.getId());
    }
}

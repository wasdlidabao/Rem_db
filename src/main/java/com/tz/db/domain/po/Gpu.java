package com.tz.db.domain.po;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Table(name = "gpu")
@org.hibernate.annotations.Table(appliesTo = "gpu", comment = "gpu")
@EntityListeners(AuditingEntityListener.class)
@ApiModel(value = "gpu")
public class Gpu extends BasePO {

    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;

}
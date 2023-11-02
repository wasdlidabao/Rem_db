package com.tz.db.domain.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author lxn
 * @date 2022年12月010日 17:55
 */
@Data
@Entity
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Table(name = "memory")
@org.hibernate.annotations.Table(appliesTo = "memory", comment = "内存")
@EntityListeners(AuditingEntityListener.class)
public class Memory extends BasePO{

    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;

    @Column(name = "memory_committed", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '提交的内存（以字节为单位）'")
    String memoryCommitted;
    @Column(name = "memory_max", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '最大内存（以字节为单位）'")
    String memoryMax;
    @Column(name = "memory_used", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '已用内存（以字节为单位）'")
    String memoryUsed;
    @Column(name = "memory_left", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '可用内存（以字节为单位）'")
    String memoryLeft;

    @Column(name = "memory_speed", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '速度（自带单位）'")
    String memorySpeed;

}

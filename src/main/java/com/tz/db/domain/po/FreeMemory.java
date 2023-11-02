package com.tz.db.domain.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "free_memory")
@org.hibernate.annotations.Table(appliesTo = "free_memory", comment = "内存信息")
@EntityListeners(AuditingEntityListener.class)
public class FreeMemory extends BasePO {
    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;

    @Column(name = "total", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '总量'")
    private String total;
    @Column(name = "used", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '使用'")
    private String used;
    @Column(name = "free", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '空闲'")
    private String free;
    @Column(name = "cache", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '缓存'")
    private String cache;
    @Column(name = "available", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '应用程序认为可用内存数量'")
    private String available;
}

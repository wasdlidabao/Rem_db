package com.tz.db.domain.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * @author lxn
 * @date 2022年12月07日 13:53
 */
@Data
@Entity
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Table(name = "disk_space")
@org.hibernate.annotations.Table(appliesTo = "disk_space", comment = "磁盘")
@EntityListeners(AuditingEntityListener.class)
public class DiskSpace extends BasePO {

    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;

    @Column(name = "total", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '总量'")
    String total;
    @Column(name = "free", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '可用'")
    String free;
    @Column(name = "used", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '已用'")
    String used;
    @Transient
    List<DiskSpaceIO> diskSpaceIOVOs;

}

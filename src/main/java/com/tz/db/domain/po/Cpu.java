package com.tz.db.domain.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author lxn
 * @date 2022年12月06日 17:55
 */
@Data
@Entity
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Table(name = "cpu")
@org.hibernate.annotations.Table(appliesTo = "cpu", comment = "cpu信息")
@EntityListeners(AuditingEntityListener.class)
public class Cpu extends BasePO {

    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;

    @Column(name = "cpu_count", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT 'cpu数量'")
    String cpuCount;
    @Column(name = "cpu_usage", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT 'cpu使用率'")
    String cpuUsage;

    @Column(name = "threads_live", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '线程数'")
    String threadsLive;

    @Column(name = "cpu_process", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '进程数'")
    String cpuProcess;
    @Column(name = "cpu_mhz", columnDefinition = "VARCHAR(30) DEFAULT NULL COMMENT '速度(MHz)'")
    String cpuMHz;

}

package com.tz.db.domain.po;

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
@Table(name = "disk_space_io")
@org.hibernate.annotations.Table(appliesTo = "disk_space_io", comment = "磁盘读写")
@EntityListeners(AuditingEntityListener.class)
public class DiskSpaceIO extends BasePO {

    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;

    @Column(name = "disk_space_id", columnDefinition = "VARCHAR(36) DEFAULT NULL COMMENT '磁盘编号'")
    String diskSpaceId;

    @Column(name = "kb_read_per_second", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '每秒读取的磁盘块的数量'")
    String kbReadPerSecond;
    @Column(name = "kb_wrtn_per_second", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '每秒写入的磁盘块的数量'")
    String kbWrtnPerSecond;
    @Column(name = "svctm", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '平均每次设备I/O操作的服务时间'")
    String svctm;
    @Column(name = "r_await", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '平均每次设备I操作的等待时间'")
    String rAwait;
    @Column(name = "w_await", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '平均每次设备O操作的等待时间'")
    String wAwait;
    @Column(name = "aquSz", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '平均I/O队列长度'")
    String aquSz;
    @Column(name = "util", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '传输率'")
    String util;

}
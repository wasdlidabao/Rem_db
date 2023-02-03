package com.tz.db.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "磁盘读写")
public class DiskSpaceIO extends BasePO {

    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;

    @ApiModelProperty(name = "diskSpaceId", value = "磁盘编号")
    @Column(name = "disk_space_id", columnDefinition = "VARCHAR(36) DEFAULT NULL COMMENT '磁盘编号'")
    String diskSpaceId;

    @ApiModelProperty(name = "kbReadPerSecond", value = "每秒读取的磁盘块的数量")
    @Column(name = "kb_read_per_second", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '每秒读取的磁盘块的数量'")
    String kbReadPerSecond;
    @ApiModelProperty(name = "kbWrtnPerSecond", value = "每秒写入的磁盘块的数量")
    @Column(name = "kb_wrtn_per_second", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '每秒写入的磁盘块的数量'")
    String kbWrtnPerSecond;
    @ApiModelProperty(name = "svctm", value = "平均每次设备I/O操作的服务时间")
    @Column(name = "svctm", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '平均每次设备I/O操作的服务时间'")
    String svctm;
    @ApiModelProperty(name = "rAwait", value = "平均每次设备I操作的等待时间")
    @Column(name = "r_await", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '平均每次设备I操作的等待时间'")
    String rAwait;
    @ApiModelProperty(name = "wAwait", value = "平均每次设备O操作的等待时间")
    @Column(name = "w_await", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '平均每次设备O操作的等待时间'")
    String wAwait;
    @ApiModelProperty(name = "aquSz", value = "平均I/O队列长度")
    @Column(name = "aquSz", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '平均I/O队列长度'")
    String aquSz;
    @ApiModelProperty(name = "util", value = "传输率")
    @Column(name = "util", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '传输率'")
    String util;

}
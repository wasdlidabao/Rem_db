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
@Table(name = "gpu_process_info")
@org.hibernate.annotations.Table(appliesTo = "gpu_process_info", comment = "gpu进程信息")
@EntityListeners(AuditingEntityListener.class)
@ApiModel(value = "gpu进程信息")
public class GpuProcessInfo extends BasePO {
    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;
    @ApiModelProperty(name = "gpusId", value = "gpus信息编号")
    @Column(name = "gpus_id", columnDefinition = "VARCHAR(36) DEFAULT NULL COMMENT 'gpus信息编号'")
    String gpusId;
    @ApiModelProperty(name = "pid", value = "pid")
    @Column(name = "pid", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT 'pid'")
    String pid;
    @ApiModelProperty(name = "name", value = "名称")
    @Column(name = "name", columnDefinition = "VARCHAR(36) DEFAULT NULL COMMENT '名称'")
    String name;
    @ApiModelProperty(name = "usedMemory", value = "已用")
    @Column(name = "used_memory", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '已用'")
    String usedMemory;

}
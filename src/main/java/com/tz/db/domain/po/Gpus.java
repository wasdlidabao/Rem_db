package com.tz.db.domain.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Table(name = "gpus")
@org.hibernate.annotations.Table(appliesTo = "gpus", comment = "gpus")
@EntityListeners(AuditingEntityListener.class)
public class Gpus extends BasePO{

    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;
    @Column(name = "gpu_id", columnDefinition = "VARCHAR(36) DEFAULT NULL COMMENT 'gpu编号'")
    String gpuId;
    @Column(name = "name", columnDefinition = "VARCHAR(125) DEFAULT NULL COMMENT '名称'")
    String name;
    @Column(name = "total_memory", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '总内存'")
    String totalMemory;
    @Column(name = "used_memory", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '已用内存'")
    String usedMemory;
    @Column(name = "free_memory", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '空闲内存'")
    String freeMemory;
    @Column(name = "usage_rate", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '使用率 整形，最大为100'")
    String usageRate;
    @Transient
    List<GpuProcessInfo> gpuProcessInfos;

    @Override
    public String toString() {
        return "GPUInfo{" +
                "name='" + name + '\'' +
                ", totalMemory='" + totalMemory + '\'' +
                ", usedMemory='" + usedMemory + '\'' +
                ", freeMemory='" + freeMemory + '\'' +
                ", usageRate=" + usageRate +
                ", gpuProcessInfos=" + gpuProcessInfos +
                '}';
    }
}
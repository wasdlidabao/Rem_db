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
@Table(name = "top")
@org.hibernate.annotations.Table(appliesTo = "top", comment = "top信息")
@EntityListeners(AuditingEntityListener.class)
public class Top extends BasePO {
    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String top_id;

    // 5.9%us — 用户空间占用CPU的百分比。
    @Column(name = "us", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '用户空间占用CPU的百分比'")
    private String us;
    // 3.4% sy — 内核空间占用CPU的百分比。
    @Column(name = "sy", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '内核空间占用CPU的百分比'")
    private String sy;
    // 0.0% ni — 改变过优先级的进程占用CPU的百分比
    @Column(name = "ni", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '改变过优先级的进程占用CPU的百分比'")
    private String ni;
    // 90.4% id — 空闲CPU百分比
    @Column(name = "id", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '空闲CPU百分比'")
    private String id;
    // 0.0% wa — IO等待占用CPU的百分比
    @Column(name = "wa", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT 'IO等待占用CPU的百分比'")
    private String wa;
    // 0.0% hi — 硬中断（Hardware IRQ）占用CPU的百分比
    @Column(name = "hi", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '硬中断（Hardware IRQ）占用CPU的百分比'")
    private String hi;
    // 0.2% si — 软中断（Software Interrupts）占用CPU的百分比
    @Column(name = "si", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '软中断（Software Interrupts）占用CPU的百分比'")
    private String si;
    @Column(name = "st", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '未知'")
    private String st;
    /**
     * Tasks: 1330 total,   1 running, 1022 sleeping,   0 stopped,   0 zombie
     * 系统现在共有1330个进程，其中处于运行中的有1个，1022个在休眠（sleep），stoped状态的有0个，zombie状态（僵尸）的有0个。
     */
    @Column(name = "task_total", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '总进程'")
    private String taskTotal;
    @Column(name = "task_running", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '运行进程'")
    private String taskRunning;
    @Column(name = "task_sleeping", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT '休眠进程'")
    private String taskSleeping;
    @Column(name = "task_stopped", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT 'stoped状态进程'")
    private String taskStopped;
    @Column(name = "task_zombie", columnDefinition = "VARCHAR(6) DEFAULT NULL COMMENT 'zombie状态（僵尸）进程'")
    private String taskZombie;
    /**
     * 内存
     */
    @Column(name = "mem_total", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '内存总量'")
    private String memTotal;
    @Column(name = "mem_free", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '内存空闲'")
    private String memFree;
    @Column(name = "mem_used", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '内存使用'")
    private String memUsed;
    @Column(name = "mem_cache", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '内存缓存'")
    private String memCache;
}

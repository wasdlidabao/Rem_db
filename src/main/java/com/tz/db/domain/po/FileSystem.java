package com.tz.db.domain.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 磁盘
 *
 * @author lxn
 * @date 2022年12月07日 13:53
 */
@Data
@Entity
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Table(name = "file_system")
@org.hibernate.annotations.Table(appliesTo = "file_system", comment = "磁盘")
@EntityListeners(AuditingEntityListener.class)
public class FileSystem extends BasePO {

    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;

    @Column(name = "base_id", columnDefinition = "VARCHAR(36) DEFAULT NULL COMMENT 'base编号'")
    String baseId;

    @Column(name = "file_system", columnDefinition = "VARCHAR(36) DEFAULT NULL COMMENT '文件系统'")
    String filesystem;

    @Column(name = "size", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '总大小'")
    String size;

    @Column(name = "used", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '已使用'")
    String used;

    @Column(name = "avail", columnDefinition = "VARCHAR(36) DEFAULT NULL COMMENT '可用空间'")
    String avail;

    @Column(name = "use_rate", columnDefinition = "VARCHAR(10) DEFAULT NULL COMMENT '使用率'")
    String useRate;

    @Column(name = "mounted_on", columnDefinition = "longtext DEFAULT NULL COMMENT '挂载点'")
    String mountedOn;

}

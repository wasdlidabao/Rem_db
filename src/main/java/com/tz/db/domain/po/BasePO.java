package com.tz.db.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BasePO implements Serializable {

    @ApiModelProperty(name = "mac", value = "mac地址")
    @Column(name = "mac", columnDefinition = "VARCHAR(36) DEFAULT NULL COMMENT 'mac地址'")
    String mac;

    @ApiModelProperty("创建时间")
    @CreatedDate
    @Column(name = "create_time")
    Date createTime;

    @ApiModelProperty("修改时间")
    @LastModifiedDate
    @Column(name = "update_time")
    Date updateTime;


}

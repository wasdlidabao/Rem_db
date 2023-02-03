package com.tz.db.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Table(name = "net")
@org.hibernate.annotations.Table(appliesTo = "net", comment = "网络")
@EntityListeners(AuditingEntityListener.class)
@ApiModel(value = "网络")
public class Net extends BasePO {
    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36, columnDefinition = "VARCHAR(36)")
    String id;

    @ApiModelProperty(name = "txPercent", value = "上行速率")
    @Column(name = "tx_percent", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '上行速率'")
    String txPercent;
    @ApiModelProperty(name = "rxPercent", value = "下行速率")
    @Column(name = "rx_percent", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '下行速率'")
    String rxPercent;
    @ApiModelProperty(name = "speed", value = "当前吞吐速率")
    @Column(name = "cur_rate", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '当前吞吐速率'")
    String curRate;
    @ApiModelProperty(name = "speed", value = "网络带宽使用率")
    @Column(name = "net_usage", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '网络带宽使用率'")
    String netUsage;
    @ApiModelProperty(name = "netMax", value = "网卡上限")
    @Column(name = "net_max", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '网卡上限'")
    String netMax;

}

package com.tz.db.domain.vo;

import com.tz.db.domain.po.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author lxn
 * @date 2022年12月07日 16:35
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "服务器性能")
public class ServerVO {

    @ApiModelProperty(name = "cpu", value = "cpu")
    Cpu cpu;
    @ApiModelProperty(name = "memory", value = "内存")
    Memory memory;
    @ApiModelProperty(name = "diskSpace", value = "磁盘")
    DiskSpace diskSpace;
    @ApiModelProperty(name = "gpus", value = "gpu")
    List<Gpus> gpus;
    @ApiModelProperty(name = "net", value = "网络")
    Net net;

}

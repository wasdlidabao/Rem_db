package com.tz.db.domain.vo;

import com.tz.db.domain.po.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author lxn
 * @date 2022年12月07日 16:35
 */
@Data
@Accessors(chain = true)
public class ServerVO {
    Top cpu;
    FreeMemory memory;
    List<FileSystem> fileSystems;
    List<Gpus> gpus;
    Net net;

    @Override
    public String toString() {
        return "ServerVO{" +
                "cpu=" + cpu +
                ", memory=" + memory +
                ", fileSystems=" + fileSystems +
                ", gpus=" + gpus +
                ", net=" + net +
                '}';
    }
}

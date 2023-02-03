package com.tz.db.service;

import com.tz.db.domain.param.RequestServerParam;
import com.tz.db.domain.vo.ServerVO;

public interface ServerService {

    /**
     * 从数据库重新并封装数据
     *
     * @return ServerVO
     */
    ServerVO findAll(String mac);

    void uploadData(RequestServerParam serverParam);
}

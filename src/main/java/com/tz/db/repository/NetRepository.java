package com.tz.db.repository;

import com.tz.db.domain.po.Net;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface NetRepository extends BaseRepository<Net> {

    @Query(value = "SELECT * FROM net WHERE mac = ? ORDER BY create_time DESC LIMIT 0,1", nativeQuery = true)
    Net findNewest(String mac);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM net WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -1 WEEK)", nativeQuery = true)
    void deleteByCreateTime();

}
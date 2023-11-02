package com.tz.db.repository;

import com.tz.db.domain.po.Top;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TopRepository extends BaseRepository<Top> {

    @Query(value = "SELECT * FROM top WHERE mac = ? ORDER BY create_time DESC LIMIT 0,1", nativeQuery = true)
    Top findNewest(String mac);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM top WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -3 DAY)", nativeQuery = true)
    void deleteByCreateTime();

}
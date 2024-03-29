package com.tz.db.repository;

import com.tz.db.domain.po.Memory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MemoryRepository extends BaseRepository<Memory> {

    @Query(value = "SELECT * FROM memory WHERE mac = ? ORDER BY create_time DESC LIMIT 0,1", nativeQuery = true)
    Memory findNewest(String mac);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM memory WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -3 DAY)", nativeQuery = true)
    void deleteByCreateTime();

}
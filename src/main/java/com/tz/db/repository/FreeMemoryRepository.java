package com.tz.db.repository;

import com.tz.db.domain.po.FreeMemory;
import com.tz.db.domain.po.Memory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface FreeMemoryRepository extends BaseRepository<FreeMemory> {

    @Query(value = "SELECT * FROM free_memory WHERE mac = ? ORDER BY create_time DESC LIMIT 0,1", nativeQuery = true)
    FreeMemory findNewest(String mac);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM free_memory WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -3 DAY)", nativeQuery = true)
    void deleteByCreateTime();

}
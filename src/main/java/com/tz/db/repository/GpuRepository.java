package com.tz.db.repository;

import com.tz.db.domain.po.Gpu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface GpuRepository extends BaseRepository<Gpu> {

    @Query(value = "SELECT * FROM gpu WHERE mac = ? ORDER BY create_time DESC LIMIT 0,1", nativeQuery = true)
    Gpu findNewest(String mac);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM gpu WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -3 DAY)", nativeQuery = true)
    void deleteByCreateTime();

}
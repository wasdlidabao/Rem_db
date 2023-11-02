package com.tz.db.repository;

import com.tz.db.domain.po.Cpu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CpuRepository extends BaseRepository<Cpu> {

    @Query(value = "SELECT * FROM cpu WHERE mac = ? ORDER BY create_time DESC LIMIT 0,1", nativeQuery = true)
    Cpu findNewest(String mac);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cpu WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -3 DAY)", nativeQuery = true)
    void deleteByCreateTime();

}
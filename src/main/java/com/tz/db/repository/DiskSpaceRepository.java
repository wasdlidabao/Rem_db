package com.tz.db.repository;

import com.tz.db.domain.po.DiskSpace;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DiskSpaceRepository extends BaseRepository<DiskSpace> {

    @Query(value = "SELECT * FROM disk_space WHERE mac = ? ORDER BY create_time DESC LIMIT 0,1", nativeQuery = true)
    DiskSpace findNewest(String mac);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM disk_space WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -1 WEEK)", nativeQuery = true)
    void deleteByCreateTime();

}
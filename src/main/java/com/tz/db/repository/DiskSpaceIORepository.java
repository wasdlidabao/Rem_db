package com.tz.db.repository;

import com.tz.db.domain.po.DiskSpaceIO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DiskSpaceIORepository extends BaseRepository<DiskSpaceIO> {

    List<DiskSpaceIO> findByDiskSpaceId(String id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM disk_space_io WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -3 DAY)", nativeQuery = true)
    void deleteByCreateTime();

}
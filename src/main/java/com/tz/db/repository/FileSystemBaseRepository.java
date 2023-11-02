package com.tz.db.repository;

import com.tz.db.domain.po.FileSystem;
import com.tz.db.domain.po.FileSystemBase;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface FileSystemBaseRepository extends BaseRepository<FileSystemBase> {

    @Query(value = "SELECT * FROM file_system_base WHERE mac = ? ORDER BY create_time DESC LIMIT 0,1", nativeQuery = true)
    FileSystemBase findNewest(String mac);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM file_system_base WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -3 DAY)", nativeQuery = true)
    void deleteByCreateTime();

}
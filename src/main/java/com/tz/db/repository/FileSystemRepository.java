package com.tz.db.repository;

import com.tz.db.domain.po.FileSystem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface FileSystemRepository extends BaseRepository<FileSystem> {

    List<FileSystem> findByBaseId(String baseId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM file_system WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -3 DAY)", nativeQuery = true)
    void deleteByCreateTime();

}
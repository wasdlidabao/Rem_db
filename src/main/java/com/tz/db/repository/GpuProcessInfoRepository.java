package com.tz.db.repository;

import com.tz.db.domain.po.GpuProcessInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface GpuProcessInfoRepository extends BaseRepository<GpuProcessInfo> {

    List<GpuProcessInfo> findByGpusId(String id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM gpu_process_info WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -1 WEEK)", nativeQuery = true)
    void deleteByCreateTime();

}
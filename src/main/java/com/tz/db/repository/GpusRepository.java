package com.tz.db.repository;

import com.tz.db.domain.po.Gpus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface GpusRepository extends BaseRepository<Gpus> {

    List<Gpus> findByGpuId(String id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM gpus WHERE create_time < DATE_ADD(CURDATE(),INTERVAL -3 DAY)", nativeQuery = true)
    void deleteByCreateTime();

}
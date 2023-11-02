package com.tz.schedule;

import com.tz.db.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class DeleteTimer {

    @Resource
    CpuRepository cpuRepository;
    @Resource
    DiskSpaceRepository diskSpaceRepository;
    @Resource
    DiskSpaceIORepository diskSpaceIORepository;
    @Resource
    GpuRepository gpuRepository;
    @Resource
    GpusRepository gpusRepository;
    @Resource
    GpuProcessInfoRepository gpuProcessInfoRepository;
    @Resource
    MemoryRepository memoryRepository;
    @Resource
    NetRepository netRepository;
    @Resource
    TopRepository topRepository;
    @Resource
    FileSystemRepository fileSystemRepository;
    @Resource
    FileSystemBaseRepository fileSystemBaseRepository;
    @Resource
    FreeMemoryRepository freeMemoryRepository;

    /**
     * 每天的23点执行一次,删除一周前的数据
     */
    @Scheduled(cron = "${timer.deleteCorn}")
    public void deleteLog() {
        try {
            cpuRepository.deleteByCreateTime();
            diskSpaceRepository.deleteByCreateTime();
            diskSpaceIORepository.deleteByCreateTime();
            gpuRepository.deleteByCreateTime();
            gpusRepository.deleteByCreateTime();
            gpuProcessInfoRepository.deleteByCreateTime();
            memoryRepository.deleteByCreateTime();
            netRepository.deleteByCreateTime();
            topRepository.deleteByCreateTime();
            fileSystemRepository.deleteByCreateTime();
            fileSystemBaseRepository.deleteByCreateTime();
            freeMemoryRepository.deleteByCreateTime();
        } catch (Exception e) {
            log.error("定时删除数据", e);
        }
    }

}
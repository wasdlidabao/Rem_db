package com.tz.db.service.impl;

import com.tz.db.domain.param.RequestServerParam;
import com.tz.db.domain.po.*;
import com.tz.db.domain.vo.ServerVO;
import com.tz.db.repository.*;
import com.tz.db.service.ServerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ServerServiceImpl implements ServerService {

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

    @Override
    public ServerVO findAll(String mac) {
        Cpu cpu = cpuRepository.findNewest(mac);
        DiskSpace diskSpace = diskSpaceRepository.findNewest(mac);
        List<DiskSpaceIO> diskSpaceIOS = diskSpaceIORepository.findByDiskSpaceId(diskSpace.getId());
        diskSpace.setDiskSpaceIOVOs(diskSpaceIOS);
        Gpu gpu = gpuRepository.findNewest(mac);
        List<Gpus> gpusList = gpusRepository.findByGpuId(gpu.getId());
        gpusList.forEach(gpus -> gpus.setGpuProcessInfos(gpuProcessInfoRepository.findByGpusId(gpus.getId())));
        Memory memory = memoryRepository.findNewest(mac);
        Net net = netRepository.findNewest(mac);
        ServerVO serverVO = new ServerVO();
        serverVO.setCpu(cpu).setGpus(gpusList).setNet(net).setDiskSpace(diskSpace).setMemory(memory);
        return serverVO;
    }

    @Override
    public void uploadData(RequestServerParam serverParam) {
        String mac = serverParam.getMac();
        ServerVO serverVO = serverParam.getServerVO();
        try {
            Cpu cpu = serverVO.getCpu();
            cpu.setMac(mac);
            cpuRepository.save(cpu);
        } catch (Exception e) {
            log.error("更新CPU异常", e);
        }

        try {
            Memory memory = memoryRepository.save(serverVO.getMemory());
            memory.setMac(mac);
        } catch (Exception e) {
            log.error("更新内存异常", e);
        }

        try {
            DiskSpace diskSpace = serverVO.getDiskSpace();
            diskSpace.setMac(mac);
            DiskSpace save = diskSpaceRepository.save(diskSpace);
            List<DiskSpaceIO> diskSpaceIOS = serverVO.getDiskSpace().getDiskSpaceIOVOs();
            diskSpaceIOS.forEach(diskSpaceIO -> {
                diskSpaceIO.setDiskSpaceId(save.getId());
                diskSpaceIO.setMac(mac);
                diskSpaceIORepository.save(diskSpaceIO);
            });
        } catch (Exception e) {
            log.error("更新磁盘异常", e);
        }

        try {
            Gpu gpu = new Gpu();
            gpu.setMac(mac);
            gpu = gpuRepository.save(gpu);
            List<Gpus> gpusList = serverVO.getGpus();
            if (CollectionUtils.isNotEmpty(gpusList)) {
                Gpu finalGpu = gpu;
                gpusList.forEach(gpus -> {
                    gpus.setGpuId(finalGpu.getId());
                    gpus.setMac(mac);
                    gpus = gpusRepository.save(gpus);
                    List<GpuProcessInfo> gpuProcessInfos = gpus.getGpuProcessInfos();
                    Gpus finalGpus = gpus;
                    gpuProcessInfos.forEach(gpuProcessInfo -> {
                        gpuProcessInfo.setGpusId(finalGpus.getId());
                        gpuProcessInfo.setMac(mac);
                        gpuProcessInfoRepository.save(gpuProcessInfo);
                    });
                });
            }
        } catch (Exception e) {
            log.error("更新GPU异常", e);
        }

        try {
            Net net = serverVO.getNet();
            net.setMac(mac);
            netRepository.save(net);
        } catch (Exception e) {
            log.error("更新网络异常", e);
        }
    }
}

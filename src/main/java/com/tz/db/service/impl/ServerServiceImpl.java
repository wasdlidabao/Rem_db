package com.tz.db.service.impl;

import com.tz.db.domain.param.RequestServerParam;
import com.tz.db.domain.po.*;
import com.tz.db.domain.vo.ServerVO;
import com.tz.db.repository.*;
import com.tz.db.service.ServerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ServerServiceImpl implements ServerService {

    @Resource
    TopRepository topRepository;
    @Resource
    FileSystemBaseRepository fileSystemBaseRepository;
    @Resource
    FileSystemRepository fileSystemRepository;
    @Resource
    GpuRepository gpuRepository;
    @Resource
    GpusRepository gpusRepository;
    @Resource
    GpuProcessInfoRepository gpuProcessInfoRepository;
    @Resource
    FreeMemoryRepository freeMemoryRepository;
    @Resource
    NetRepository netRepository;

    @Override
    public ServerVO findAll(String mac) {
        Top top = topRepository.findNewest(mac);
        FileSystemBase fileSystemBase = new FileSystemBase();
        if (ObjectUtils.isNotEmpty(top)) {
            fileSystemBase = fileSystemBaseRepository.findNewest(mac);
        }
        List<FileSystem> fileSystems = new ArrayList<>();
        if (ObjectUtils.isNotEmpty(fileSystemBase)) {
            fileSystems.addAll(fileSystemRepository.findByBaseId(fileSystemBase.getId()));
        }
        Gpu gpu = gpuRepository.findNewest(mac);
        List<Gpus> gpusList = new ArrayList<>();
        if (ObjectUtils.isNotEmpty(gpu)) {
            gpusList.addAll(gpusRepository.findByGpuId(gpu.getId()));
        }
        gpusList.forEach(gpus -> gpus.setGpuProcessInfos(gpuProcessInfoRepository.findByGpusId(gpus.getId())));
        FreeMemory memory = freeMemoryRepository.findNewest(mac);
        Net net = netRepository.findNewest(mac);
        ServerVO serverVO = new ServerVO().setCpu(top).setGpus(gpusList).setNet(net).setFileSystems(fileSystems).setMemory(memory);
        return serverVO;
    }

    @Override
    public void uploadData(RequestServerParam serverParam) {
        String mac = serverParam.getMac();
        ServerVO serverVO = serverParam.getServerVO();
        log.info("====>" + serverVO.toString());
        if (StringUtils.isNotEmpty(serverVO.getCpu().getHi())) {
            try {
                Top top = serverVO.getCpu();
                top.setMac(mac);
                topRepository.save(top);
            } catch (Exception e) {
                log.error("更新CPU异常", e);
            }
        }
        if (ObjectUtils.isNotEmpty(serverVO.getMemory().getTotal())) {
            try {
                FreeMemory memory = serverVO.getMemory();
                memory.setMac(mac);
                freeMemoryRepository.save(memory);
            } catch (Exception e) {
                log.error("更新内存异常", e);
            }
        }
        if (CollectionUtils.isNotEmpty(serverVO.getFileSystems())) {
            try {
                FileSystemBase base = new FileSystemBase();
                base.setMac(mac);
                base = fileSystemBaseRepository.save(base);
                List<FileSystem> fileSystems = serverVO.getFileSystems();
                if (CollectionUtils.isNotEmpty(fileSystems)) {
                    FileSystemBase finalBase = base;
                    fileSystems.forEach(fileSystem -> {
                        fileSystem.setMac(mac);
                        fileSystem.setBaseId(finalBase.getId());
                        fileSystemRepository.save(fileSystem);
                    });
                }
            } catch (Exception e) {
                log.error("更新磁盘异常", e);
            }
        }
        if (CollectionUtils.isNotEmpty(serverVO.getGpus())) {
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
        }
        if (ObjectUtils.isNotEmpty(serverVO.getNet().getNetMax())) {
            try {
                Net net = serverVO.getNet();
                net.setMac(mac);
                netRepository.save(net);
            } catch (Exception e) {
                log.error("更新网络异常", e);
            }
        }
    }
}

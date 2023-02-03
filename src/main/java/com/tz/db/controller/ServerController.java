package com.tz.db.controller;

import com.tz.db.domain.param.RequestServerParam;
import com.tz.db.domain.vo.ServerVO;
import com.tz.db.service.ServerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "服务器信息操作")
@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    ServerService serverService;

    @ApiOperation("查询数据库")
    @GetMapping("/select/{mac}")
    public ResponseEntity<ServerVO> select(@PathVariable String mac) {
        return ResponseEntity.ok(serverService.findAll(mac));
    }

    @ApiOperation("资源服务上传数据")
    @ApiImplicitParam(name = "serverParam", value = "上传数据", dataType = "RequestServerParam", paramType = "body")
    @PostMapping("/uploadData")
    public ResponseEntity<HttpStatus> uploadData(@RequestBody RequestServerParam serverParam) {
        serverService.uploadData(serverParam);
        return ResponseEntity.ok().build();
    }

}

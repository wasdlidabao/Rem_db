package com.tz.db.controller;

import com.tz.db.domain.param.RequestServerParam;
import com.tz.db.domain.vo.ServerVO;
import com.tz.db.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    ServerService serverService;

    @GetMapping("/select/{mac}")
    public ResponseEntity<ServerVO> select(@PathVariable String mac) {
        return ResponseEntity.ok(serverService.findAll(mac));
    }

    @PostMapping("/uploadData")
    public ResponseEntity<HttpStatus> uploadData(@RequestBody RequestServerParam serverParam) {
        serverService.uploadData(serverParam);
        return ResponseEntity.ok().build();
    }

}

package com.yuan.springcloud.microservicecloudconsumerdeptfeign.controller;

import com.yuan.springcloud.microservicecloudapi.domain.entity.Dept;
import com.yuan.springcloud.microservicecloudapi.service.DeptClientService;
import com.yuan.springcloud.microservicecloudapi.service.DeptClientServiceFallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Hong
 * @version 1.0
 * @description dept controller
 */
@Slf4j
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    @PostMapping("/add")
    public Object add(@RequestBody Dept dept) {
        log.info("/add");
        return deptClientService.add(dept);
    }

    @GetMapping("/get/{id}")
    public Object get(@PathVariable Long id) {
        log.info("/get/id");
        return deptClientService.get(id);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        log.info("/discovery");
        return deptClientService.discovery();
    }

}

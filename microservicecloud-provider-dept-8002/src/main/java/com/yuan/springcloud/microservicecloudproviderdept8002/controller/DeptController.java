package com.yuan.springcloud.microservicecloudproviderdept8002.controller;

import com.yuan.springcloud.microservicecloudapi.domain.entity.Dept;
import com.yuan.springcloud.microservicecloudproviderdept8002.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author David Hong
 * @version 1.0
 * @description 部门controller
 */
@Slf4j
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public Object add(@RequestBody Dept dept) {
        log.info(dept.toString());
        deptService.save(dept);
        return "succ";
    }

    @GetMapping("/get/{id}")
    public Object get(@PathVariable Long id) {
        return deptService.getById(id);
    }

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> list = client.getServices();
        log.info("{}", list);
        List<ServiceInstance> serviceInstanceList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance serviceInstance: serviceInstanceList) {
            log.info("{}, {}, {}, {}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getUri());
        }
        return this.client;
    }

}

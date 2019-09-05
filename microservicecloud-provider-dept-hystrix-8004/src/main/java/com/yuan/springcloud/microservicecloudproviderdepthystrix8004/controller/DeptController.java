package com.yuan.springcloud.microservicecloudproviderdepthystrix8004.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yuan.springcloud.microservicecloudapi.domain.entity.Dept;
import com.yuan.springcloud.microservicecloudproviderdepthystrix8004.service.DeptService;
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
    // 一旦dept为null，则进入fallbackMethod，进行服务熔断
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public Object get(@PathVariable Long id) {
        Dept dept = deptService.getById(id);
        if (dept == null) {
            throw new RuntimeException("该ID: " + id + "没有对应信息");
        }
        return dept;
    }

    public Object processHystrixGet(@PathVariable Long id) {
        return new Dept().setDpName("该"+id+"没有记录").setDbSource("没有数据源").setId(0L);
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

package com.yuan.springcloud.microservicecloudapi.service;

import com.yuan.springcloud.microservicecloudapi.domain.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author David Hong
 * @version 1.0
 * @description dept fegin service
 */
@FeignClient(name = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @PostMapping("/dept/add")
    Object add(@RequestBody Dept dept);

    @GetMapping("/dept/get/{id}")
    Object get(@PathVariable Long id);

    @GetMapping("/dept/discovery")
    Object discovery();

}

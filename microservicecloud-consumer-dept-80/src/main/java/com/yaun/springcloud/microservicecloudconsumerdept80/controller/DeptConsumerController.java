package com.yaun.springcloud.microservicecloudconsumerdept80.controller;

import com.yuan.springcloud.microservicecloudapi.domain.entity.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author David Hong
 * @version 1.0
 * @description dept controller
 */
@Slf4j
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    // private static final String REST_URL_PREFIX= "http://localhost:8001";
    private static final String REST_URL_PREFIX= "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public Object add(@RequestBody Dept dept) {
        log.info("/add");
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Object.class);
    }

    @GetMapping("/get/{id}")
    public Object get(@PathVariable Long id) {
        log.info("/get/id");
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Object.class);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        log.info("/discovery");
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }

}

package com.yuan.springcloud.microservicecloudconfigclient9900.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Hong
 * @version 1.0
 * @description 配置controller
 */
@Slf4j
@RestController
public class ConfigController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        log.info("applicationName={}, eurekaServers={}, port={}", applicationName, eurekaServers, port);
        return "applicationName=" + applicationName + ", eurekaServers=" + eurekaServers + ", port=" + port;
    }


}

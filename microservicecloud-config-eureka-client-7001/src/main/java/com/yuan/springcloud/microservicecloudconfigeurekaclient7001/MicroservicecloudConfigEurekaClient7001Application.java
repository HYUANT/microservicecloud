package com.yuan.springcloud.microservicecloudconfigeurekaclient7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroservicecloudConfigEurekaClient7001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudConfigEurekaClient7001Application.class, args);
    }

}

package com.yuan.springcloud.microservicecloudconfig9988;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MicroservicecloudConfig9988Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudConfig9988Application.class, args);
    }

}

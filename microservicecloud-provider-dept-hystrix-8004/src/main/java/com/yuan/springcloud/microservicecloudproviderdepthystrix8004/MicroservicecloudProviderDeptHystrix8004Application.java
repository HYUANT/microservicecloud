package com.yuan.springcloud.microservicecloudproviderdepthystrix8004;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableCircuitBreaker // 添加对hystrix的支持
@EnableEurekaClient
@EnableDiscoveryClient // 服务发现
@SpringBootApplication
@MapperScan("com.yuan.springcloud.microservicecloudproviderdepthystrix8004.mapper")
@EnableHystrix
public class MicroservicecloudProviderDeptHystrix8004Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudProviderDeptHystrix8004Application.class, args);
	}

}

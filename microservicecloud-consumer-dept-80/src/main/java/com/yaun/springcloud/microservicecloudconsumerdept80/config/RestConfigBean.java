package com.yaun.springcloud.microservicecloudconsumerdept80.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author David Hong
 * @version 1.0
 * @description RestTemplate配置类
 */
@Configuration
public class RestConfigBean {

    @Bean
    // spring cloud ribbon是基于Netflix ribbon实现的一套客户端负载均衡工具
    @LoadBalanced // ribbon配置restTemplate负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        // 使用随机算法替代轮训算法
        return new RandomRule();
        // return new RetryRule();
    }

}

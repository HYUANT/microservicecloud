package com.yuan.springcloud.microservicecloudapi.service;

import com.yuan.springcloud.microservicecloudapi.domain.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author David Hong
 * @version 1.0
 * @description dept fegin service
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Object add(Dept dept) {
                return "添加"+ dept + "失败";
            }

            @Override
            public Object get(Long id) {
                return "这是降级信息, 获取id="+ id + "记录失败";
            }

            @Override
            public Object discovery() {
                return "这是降级信息";
            }
        };
    }

}

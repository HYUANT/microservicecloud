package com.yuan.springcloud.microservicecloudconfigdeptclient8001.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.springcloud.microservicecloudapi.domain.entity.Dept;
import com.yuan.springcloud.microservicecloudconfigdeptclient8001.mapper.DeptMapper;
import com.yuan.springcloud.microservicecloudconfigdeptclient8001.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门类 服务实现类
 * </p>
 *
 * @author yuan
 * @since 2019-05-31
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}

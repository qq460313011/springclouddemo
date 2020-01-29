package com.fw.springcloud.controller;

import com.fw.springcloud.pojo.Dept;
import com.fw.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author li
 * @Date 2020/1/27 13:36
 **/

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id) {

        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("id=>" + id + "不存在该用户,信息无法找到~");
        }
        return dept;
    }



    public Dept hystrixGet(@PathVariable("id") Long id) {

        Dept dept = deptService.queryById(id);
        return new Dept().setDeptno(id).setDname("id=>" + id + "不存在该用户,信息无法找到~").setDb_source("不存在数据库");
    }
}

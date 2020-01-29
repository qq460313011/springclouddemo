package com.fw.springcloud.controller;

import com.fw.springcloud.pojo.Dept;
import com.fw.springcloud.service.DeptService;
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

    @Autowired
    private DiscoveryClient discoveryClient;


    @PostMapping("/dept/add")
    public boolean addDept(Dept dept)
    {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id")Long id)
    {
        return  deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll()
    {
        return  deptService.queryAll();
    }


    @GetMapping("/dept/discover")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services= discoveryClient.getServices();
        System.out.println("discovery=>services"+services);

        List<ServiceInstance> serviceInstances= discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for (ServiceInstance instance:serviceInstances) {
            System.out.println(instance.getHost()+"--"+instance.getPort()+"--"+instance.getUri()+"--"+instance.getServiceId());
        }
        return  this.discoveryClient;
    }

}

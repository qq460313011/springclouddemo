package com.fw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName
 * @Description TODO
 * @Author li
 * @Date 2020/1/27 13:41
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //服务发现
public class DeptProvider_8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001.class,args);
    }

}

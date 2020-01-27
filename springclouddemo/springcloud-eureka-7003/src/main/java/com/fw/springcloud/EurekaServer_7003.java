package com.fw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName
 * @Description TODO
 * @Author li
 * @Date 2020/1/27 14:49
 **/
@SpringBootApplication
@EnableEurekaServer //开启Eureka服务
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class,args);
    }
}

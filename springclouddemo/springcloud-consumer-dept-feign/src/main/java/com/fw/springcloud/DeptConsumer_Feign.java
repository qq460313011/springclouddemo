package com.fw.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @ClassName
 * @Description TODO
 * @Author li
 * @Date 2020/1/27 14:08
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.fw.springcloud"})
@ComponentScan("com.fw.springcloud")
public class DeptConsumer_Feign {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Feign.class,args);
    }
}

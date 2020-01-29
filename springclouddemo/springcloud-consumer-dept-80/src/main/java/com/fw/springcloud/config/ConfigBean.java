package com.fw.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * @ClassName
 * @Description TODO
 * @Author li
 * @Date 2020/1/27 13:56
 **/
@Configuration
public class ConfigBean {



    //配置负载均衡实现RestTemplete
    @Bean
    @LoadBalanced //Ribbon
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}

package com.fw.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName
 * @Description TODO
 * @Author li
 * @Date 2020/1/28 11:14
 **/
@Configuration
public class FWRule {

    @Bean
    public IRule myRule() {
        return new FWLoadBalancerRule();
    }
}

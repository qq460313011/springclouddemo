package com.fw.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName
 * @Description TODO
 * @Author li
 * @Date 2020/1/28 10:52
 **/


public class FWLoadBalancerRule extends AbstractLoadBalancerRule {

    //每个服务访问5次换下一个
    //total =0 到5的时候换下一个 index +1
    //index =0 如果index=3

    private int total=0;
    private int currentIndex=0;




    //@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            //获得可用的服务
            List<Server> upList = lb.getReachableServers();
            //获得全部服务
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            if (total<5)
            {
                server = upList.get(currentIndex);
                total++;
            }else {
                total =0;
                currentIndex++;
                if (currentIndex>upList.size())
                {
                    currentIndex =0;
                }
                server = upList.get(currentIndex);
            }




            //随机数
//            int index = chooseRandomInt(serverCount);
//
//            //从活着的的服务中拿一个
//            server = upList.get(index);

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }


}

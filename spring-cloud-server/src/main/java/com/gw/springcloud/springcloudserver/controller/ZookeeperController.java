package com.gw.springcloud.springcloudserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供Rest Api，根据实例名称获取注册服务列表
 *
 * @author GuanWeiMail@163.com
 */
@RestController
@RequestMapping("/zookeeper")
public class ZookeeperController {

    @Value("${spring.application.name}")
    private String instanceName;

    private final DiscoveryClient discoveryClient;

    @Autowired
    public ZookeeperController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping
    public String hello() {
        return "Hello,Zookeeper.";
    }

    @GetMapping("/services")
    public List<String> serviceUrl() {
        //可获得ServiceInstances列表，列表中每一项均对应了一个注册到Eureka服务器的leaderboard服务。从简化的角度考虑，可以从列表中选择第一项服务用于远程调用。
        List<ServiceInstance> list = discoveryClient.getInstances(instanceName);
        List<String> services = new ArrayList<>();
        if (list != null && list.size() > 0 ) {
            list.forEach(serviceInstance -> {
                services.add(serviceInstance.getUri().toString());
            });
        }
        return services;
    }


}
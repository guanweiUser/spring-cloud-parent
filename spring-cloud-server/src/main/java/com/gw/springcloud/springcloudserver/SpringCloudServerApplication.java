package com.gw.springcloud.springcloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * zookeeper作为服务注册中心，应用启动类
 * @author GuamWeiMail@163.com
 */

@EnableDiscoveryClient //注册服务器 spring cloud 实现服务注册@
@SpringBootApplication
public class SpringCloudServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCloudServerApplication.class, args);
	}
}

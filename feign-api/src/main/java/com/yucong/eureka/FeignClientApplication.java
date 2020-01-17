package com.yucong.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


// 启动发现机制: 就是辅助Feign技术，发现服务，定义服务动态代理的辅助技术。
@EnableDiscoveryClient

// 启动FeignClient技术: 开启Feign的应用
@EnableFeignClients

@EnableCircuitBreaker

// 使用HyStrix Dashbord 数据监控需要添加以下两个注解
@EnableHystrix
@EnableHystrixDashboard

@SpringBootApplication
public class FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
	
}

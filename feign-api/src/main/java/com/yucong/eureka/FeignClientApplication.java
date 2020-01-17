package com.yucong.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


// 
@EnableCircuitBreaker

// 启动FeignClient技术: 开启Feign的应用
@EnableFeignClients

// 启动发现机制: 就是辅助Feign技术，发现服务，定义服务动态代理的辅助技术。
@EnableDiscoveryClient


// 
@EnableHystrix

@SpringBootApplication
public class FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
	
}

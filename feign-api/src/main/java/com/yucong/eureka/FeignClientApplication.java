package com.yucong.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;


// 启动发现机制: 就是辅助Feign技术，发现服务，定义服务动态代理的辅助技术。

// 点对点直连测试时需求注释掉
@EnableDiscoveryClient

// 启动FeignClient技术: 开启Feign的应用
@EnableFeignClients

// 开启hystrix熔断器 
@EnableCircuitBreaker

// 使用HyStrix Dashbord 数据监控需要添加以下两个注解
@EnableHystrix
@EnableHystrixDashboard

@SpringBootApplication
public class FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
	
	/**
	 * 解决在使用hystrix dashboard仪表盘时，页面总是Unable to connect to Command Metric Stream
	 * 使用Spring Cloud Finchley，尝试断路器（hystrix）功能，
	 */
	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	  }
	
}

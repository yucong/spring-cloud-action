package com.yucong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
 * @EnableZuulProxy 开启zuul网关
 * 
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServerApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZuulServerApplication.class, args);
	}
	
	/**
	 * springboot 版本如果是2.0则需要添加 ServletRegistrationBean
	 * 因为springboot的默认路径不是 "/hystrix.stream"
	 */
	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
	    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
	    ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
	    registrationBean.setLoadOnStartup(1);
	    registrationBean.addUrlMappings("/hystrix.stream");
	    registrationBean.setName("HystrixMetricsStreamServlet");
	    return registrationBean;
	}
	


}


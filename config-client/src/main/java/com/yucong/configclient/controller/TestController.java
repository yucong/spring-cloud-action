package com.yucong.configclient.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope - 刷新当前对象的管理作用域。
 *  保证spring容器管理的bean对象，在刷新的时候，连同作用域数据同步刷新。
 *  当前类型的对象中的属性同步刷新。
 */
@RestController
@RefreshScope
public class TestController {

	@Value("${test.config.db.url}")
	private String url;
	@Value("${test.config.db.driver-class-name}")
	private String driverClassName;
	@Value("${test.config.db.username}")
	private String username;
	@Value("${test.config.db.password}")
	private String password;

	
	@GetMapping("/test")
	public Map<String,String> test(){
		Map<String,String> map = new HashMap<>();
		map.put("url", url);
		map.put("driverClassName", driverClassName);
		map.put("username", username);
		map.put("password", password);
		return map;
	}
	
}

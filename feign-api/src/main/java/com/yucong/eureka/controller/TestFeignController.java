package com.yucong.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yucong.api.pojo.Commodity;
import com.yucong.eureka.service.FirstClientFeignService;

/**
 * Application Client中的控制器。是和用户直接交互的控制器。
 * 像平时开发代码一样。调用本地的一个service接口。通过service接口远程访问Application Service。
 */
@RestController
public class TestFeignController {

	/**
	 * 本地定义的服务接口。用于实现远程调用application  service的接口。
	 */
	@Autowired
	private FirstClientFeignService commodityService;
	
	/**
	 * 无参
	 */
	@GetMapping("/testFeign")
	public List<String> testFeign(){
		System.out.println(commodityService.getClass().getName());
		return commodityService.testFeign();
	}
	
	/**
	 * 一个参数，调用远程服务的时候，发起的请求是GET请求
	 */
	@GetMapping("/get/{id}")
	public Commodity getById(@PathVariable("id") Long id){
		return commodityService.getById(id);
	}
	
	/**
	 * 一个参数，调用远程服务的时候，发起的请求是POST请求
	 */
	@GetMapping("/get")
	public Commodity getByIdWithPOST(Long id){
		return commodityService.getByIdWithPOST(id);
	}
	
	/**
	 * 多个参数，调用远程服务的时候，发起的请求是GET请求
	 */
	@GetMapping("/add/{id}/{name}")
	public Commodity add(@PathVariable("id") Long id, @PathVariable("name") String name){
		return commodityService.add(id, name);
	}
	
	/**
	 * 自定义类型参数，调用远程服务的时候，发起的请求是POST请求
	 * feign技术远程访问application service的时候，默认情况下GET请求不能传递自定义类型参数
	 */
	@GetMapping("/add")
	public Commodity add(Commodity pojo){
		return commodityService.add(pojo);
		//return commodityService.addWithPOST(pojo);
	}
	
}

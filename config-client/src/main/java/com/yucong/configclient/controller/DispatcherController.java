package com.yucong.configclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DispatcherController {
	
	@GetMapping("/")
	public String test(){
		return "index";
	}
	
}

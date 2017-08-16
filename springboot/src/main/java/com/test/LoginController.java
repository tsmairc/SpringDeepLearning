package com.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController{
	
	@RequestMapping("/test.do")
	public String test(){
		return "这是spring boot";
	}
}

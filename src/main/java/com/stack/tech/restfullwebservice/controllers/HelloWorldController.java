package com.stack.tech.restfullwebservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stack.tech.restfullwebservice.bean.HelloWorldBean;

@RestController
public class HelloWorldController {

	
	@GetMapping(value = "/hello")
	public String helloWorld() {
		
		return "Hello Word";
	}
	
	
	@GetMapping(value = "/hellobean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("Hello Word");
	}
	
	@GetMapping(value = "/hello/pathvariable/{name}")
	public HelloWorldBean helloWorldBeanpathvariabe(@PathVariable String name) {
		
		return new HelloWorldBean("Hello Word "+name);
	}
	
	
	
	
}

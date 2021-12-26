package com.stack.tech.restfullwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stack.tech.restfullwebservice.controllers.UserController;

@SpringBootApplication
public class RestfullwebserviceApplication {
	private static final Logger logger = LoggerFactory.getLogger(RestfullwebserviceApplication.class);
	public static void main(String[] args) {
		logger.debug("Start");
		SpringApplication.run(RestfullwebserviceApplication.class, args);
	}

}

package com.stack.tech.restfullwebservice.controllers;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stack.tech.restfullwebservice.bean.HelloWorldBean;
import com.stack.tech.restfullwebservice.bean.User;
import com.stack.tech.restfullwebservice.doa.UserDaoService;
import com.stack.tech.restfullwebservice.exception.UserNotFoundException;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserDaoService userdaoservice;

	@GetMapping(value = "/users")
	public List<User> findAll() {
		logger.info("Get method");
		return userdaoservice.getAllUser();

	}

	@GetMapping(value = "users/{id}")
	public User reteriveUser(@PathVariable int id)  {

		logger.info("Get method by id");
		User user = userdaoservice.getUserbyId(id);
		if (user == null) {
			throw new UserNotFoundException("id---" + id);
		}

		return userdaoservice.getUserbyId(id);

	}

	@PostMapping(value = "/users")
	public void createUser(@RequestBody User user) {

		logger.info("Post method");
		User saveuser = userdaoservice.Save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveuser.getId())
				.toUri();
		ResponseEntity.created(location);
	}

	
	  @DeleteMapping(value = "/users/{id}")
	  
	  public User deleteUser(@PathVariable int id) {
	  
		  logger.info("delete method");
		  
	   return userdaoservice.deletebyId(id); 
	   
	  }
	 

}

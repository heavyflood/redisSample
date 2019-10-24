package com.example.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.service.UserService;

@RestController
public class userController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/user/do")
	public String doSomething() {
		String result = userService.repo_test();
		return result;
	}
	
	@RequestMapping("/user/getVal/{id}")
	public String getEmail(@PathVariable String id) {
		String strId = id;
		String result = userService.getEmail(strId);
		return result;
	}

}

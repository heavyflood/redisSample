package com.example.demo;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;


@SpringBootApplication
@RestController
public class RedisTestApplication {

    @Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(RedisTestApplication.class, args);
	}

	@RequestMapping("/")
	public String init() {

		return "success";
	}
}

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
	public String init(HttpSession session) {
		String result;
		ValueOperations<String, Object> vop = redisTemplate.opsForValue();
		HashOperations<String, String, String> hop = redisTemplate.opsForHash();

		String SessionId = "spring:session:sessions:" + session.getId();
		if (session.getAttribute("token")==null) {
			session.setAttribute("token", "t010100101010");
		}else {
			SessionId = session.getAttribute("token").toString();
			Map<String, String> entry = hop.entries("test:user:heavyflood");
			if (entry.isEmpty()) {
				hop.put("test:user:heavyflood", "name", "harry");
				hop.put("test:user:heavyflood", "birth", "19730811");
				hop.put("test:user:heavyflood", "sex", "male");
				hop.put("test:user:heavyflood", "weight", "68kg");
				hop.put("test:user:heavyflood", "company", "sicc");
			}
		}
		
		return SessionId;
	}
	
	@RequestMapping("/user/{userId}")
	public String getUser(HttpSession session, @PathVariable String userId ) {
		String userid = userId;
		String result;
		
		HashOperations<String, String, String> hop = redisTemplate.opsForHash();
		StringBuilder sb = new StringBuilder();
		
		if (session.getAttribute("token")==null) {
			session.setAttribute("token", "t010100101010");
		}else {
			Map<String, String> entry = hop.entries("test:user:"+userid);
			
			sb.append("name : " + entry.get("name") + "\n");
			sb.append("birth : " + entry.get("birth") + "\n");
			sb.append("sex : " + entry.get("sex") + "/n");
			sb.append("weight : " + entry.get("weight") + "\n");
			sb.append("company : " + entry.get("company"));
		}
		
		return sb.toString();
	}
}

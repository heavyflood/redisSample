package com.example.demo.user.service;

import java.awt.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import com.example.demo.user.domain.UserVO;
import com.example.demo.user.service.impl.UserServiceImpl;

@Service
public class UserService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    UserServiceImpl userServiceImpl;
    	
    public String repo_test() {
    	
    	UserVO userVO = new UserVO();
        userVO.setId("2192012");
        userVO.setEmail("jiwan8935@gmail.com");
        userVO.setUsername("jiwan");

        userServiceImpl.save(userVO);

        Optional<UserVO> byId = userServiceImpl.findById(userVO.getId());
        System.out.println(byId.orElse(new UserVO()).getUsername());
        System.out.println(byId.orElse(new UserVO()).getEmail());
        
        return "success";
    }
    
    public String getEmail(String strId) {
    	ValueOperations<String, String> values = redisTemplate.opsForValue();
    	Optional<UserVO> byId = userServiceImpl.findById(strId);
    	
    	String email = byId.orElse(new UserVO()).getEmail();
    	return email;
    	
    }
    
}

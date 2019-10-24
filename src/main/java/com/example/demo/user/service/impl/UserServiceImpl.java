package com.example.demo.user.service.impl;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.user.domain.UserVO;

public interface UserServiceImpl extends CrudRepository<UserVO, String> {
}

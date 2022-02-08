package com.example.demo.service;

import com.example.demo.mapper.TestMapper;
import com.example.demo.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    public TestMapper testMapper;

    public TestVO selectTest(){
        return testMapper.selectTest();
    }
}

package com.example.demo.controller;

import com.example.demo.service.TestService;
import com.example.demo.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public TestVO selectTest(){
        return testService.selectTest();
    }
}

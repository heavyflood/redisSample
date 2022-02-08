package com.example.demo.mapper;

import com.example.demo.vo.TestVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    TestVO selectTest();
}

package com.example.demo.mapper;

import com.example.demo.vo.TestVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    TestVO selectTest();
}

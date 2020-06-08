package com.by.km;

import com.by.km.entity.Demo;
import com.by.km.mapper.DemoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KmApplicationTests {

    @Autowired
    private DemoMapper demoMapper;

    @Test
    void contextLoads() {
        List<Demo> demos = demoMapper.queryAll();
        System.out.println(demos);
    }

}

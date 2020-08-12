package com.by.km;

import com.by.km.dao.DemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class KmApplicationTests {

    @Resource
    private DemoRepository demoRepository;

    @Test
    void contextLoads() {
        System.out.println(demoRepository.findAll());

    }

}

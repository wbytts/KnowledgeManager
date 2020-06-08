package com.by.km.service;

import com.by.km.entity.Demo;
import com.by.km.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bingyi
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Demo> queryAll() {
        return demoMapper.queryAll();
    }
}

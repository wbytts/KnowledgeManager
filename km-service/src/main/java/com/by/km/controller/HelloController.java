package com.by.km.controller;

import com.by.km.entity.Demo;
import com.by.km.service.DemoService;
import com.by.km.utils.FastJsonUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author bingyi
 */
@Controller
public class HelloController {

    @Autowired
    private DemoService demoService;


    @RequestMapping("/hello")
    @ResponseBody
    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    String hello() {
        List<Demo> demos = demoService.queryAll();
        return FastJsonUtils.obj2json(demos, true);
    }

}

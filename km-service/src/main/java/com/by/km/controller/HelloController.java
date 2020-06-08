package com.by.km.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bingyi
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return "Hello World";
    }

}

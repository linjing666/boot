package com.light.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class FreemarkerController {

    @GetMapping("/helloweb")
    public String hello(Map<String,Object> map) {

        map.put("msg", "Hello Freemarker");
        return "/helloweb";
    }
}
package com.light.spring.controller;

import com.light.spring.Entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(value = "FastJson测试", tags = { "测试接口" })
@RestController
@RequestMapping("fastjson")
public class FastJsonController {

//    @ApiOperation("获取用户信息")
//    @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
    @GetMapping("/test")
    public User test( String name) {
        User user = new User();

        user.setId(1);
        user.setUsername(name);
        user.setPassword("jack123");
        user.setBirthday(new Date());

        return user;
    }
}
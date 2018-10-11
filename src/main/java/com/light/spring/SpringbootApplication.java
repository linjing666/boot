package com.light.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 该注解指定项目为springboot，由此类当作程序入口
 自动装配 web 依赖的环境

 **/
@SpringBootApplication
@EnableScheduling
@EnableCaching
@MapperScan("com.light.spring.Dao.DepartmentMapper")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
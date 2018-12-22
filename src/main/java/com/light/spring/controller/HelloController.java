package com.light.spring.controller;

import com.light.spring.Dao.RedisDao;
import com.light.spring.Entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

//    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    /**
     * 测试hello
     * @return
     */
    @Autowired
    private RedisDao redisDao;
    @GetMapping(value = "/")
    public String  login(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String hello(String username, String password, HttpServletRequest request) {
        HttpSession session=request.getSession();
        Assert.notNull(username, "账号不能为空！");
        Assert.notNull(password, "密码不能为空！");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        redisDao.set(username,"1");
        session.setAttribute("user",user);
        return "index";
    }
    @GetMapping(value = "/test")
    public String  test(){
        return "table";
    }

}

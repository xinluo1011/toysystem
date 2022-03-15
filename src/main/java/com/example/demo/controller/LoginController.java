package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.example.demo.service.UserService;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value ="/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session){
        //对html标签进行转义，防止XSS攻击
        String username =requestUser.getUsername();
        username= HtmlUtils.htmlEscape(username);

        User user=userService.get(username,requestUser.getPassword());
        if(null==user){
            return new Result(400);
        }else{
            /**
             * 将用户信息存在Session对象中（当用户在应用程序的WEB之间跳转时，存储在Session对象中的变量不会丢失）
             * 这样在访问别的页面时，可以通过判断是否存在用户变量来判断用户是否登录。
             */
            session.setAttribute("user",user);
            //如果账号是用户（false），code返回200，如果是管理员（true），code返回100
            Result result=user.getState()==true ? new Result(100) : new Result(200);
            return result;
        }
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user)throws Exception{
        int i=userService.addUser(user);
        if (i==0){
            return "error";
        }else{
            return "success";
        }
    }
}

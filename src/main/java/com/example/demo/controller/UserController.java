package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Toy;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @CrossOrigin
    @GetMapping("/users")
    public List<User> list(){
        return userService.list();
    }

    @CrossOrigin
    @GetMapping(value = "/user/{username}/user")
    @ResponseBody
    public Integer findByName(@PathVariable("username") String username){
        User user = userService.getUserByName(username);
        return user.getId();
    }

    @ResponseBody
    @CrossOrigin
    @GetMapping(value = "/user/{id}/userid")
    public User findById(@PathVariable("id") Integer id){
        User user= userService.getUserById(id);
        return user;
    }

    @CrossOrigin
    @GetMapping(value = "/user/{username}/name")
    @ResponseBody
    public User findAllByName(@PathVariable("username") String username){
        return userService.getUserByName(username);
    }

    @CrossOrigin
    @PostMapping(value = "/edituser")
    @ResponseBody
    public  String editUser(@RequestBody User user){
        int i=userService.editUser(user);
        if(i==0){
            return "error";
        }else{
            return "success";
        }
    }

    @ResponseBody
    @CrossOrigin
    @GetMapping("/searchuser")
    public List<User> searchResult(@RequestParam("keywords") String keywords){
        //关键词为空查出全部用户
        if("".equals(keywords)){
            return userService.list();
        }else{
            return userService.Search(keywords);
        }
    }

    @ResponseBody
    @CrossOrigin
    @PostMapping("/adduser")
    public String addUser(@RequestBody User user){
        int i=userService.addUser(user);
        if (i==0){
            return "error";
        }else{
            return "success";
        }
    }

    @CrossOrigin
    @PostMapping(value = "/userstate")
    @ResponseBody
    public String updateUserState(@RequestBody User user){
        int i =userService.updateUserState(user);
        if(i==0){
            return "error";
        }else {
            return "success";
        }
    }

    @ResponseBody
    @CrossOrigin
    @PostMapping("/deleteuser")
    public void  deleteByUserId(@RequestBody User user){
        userService.deleteByUserId(user.getId());
    }
}

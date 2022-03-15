package com.example.demo.service;


import com.example.demo.pojo.Toy;
import com.example.demo.pojo.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User get(String username,String password);
    Integer addUser(User user);
    User getUserByName(String username);
    Integer editUser(User user);
    List<User> Search(String keywords);
    User getUserById(Integer id);
    Integer updateUserState(User user);
    public void  deleteByUserId(Integer id);
}

package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Toy;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@MapperScan("com.example.demo.dao")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public User get(String username,String password) {
        return userDao.findUser(username,password);
    }

    @Override
    public Integer addUser(User user){
        return userDao.addUser(user);
    }

    @Override
    public User getUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public Integer editUser(User user) {
        return userDao.editUser(user);
    }

    @Override
    public List<User> Search(String keywords) {
        return userDao.Search(keywords);
    }

    @Override
    public User getUserById(Integer id) {
        return  userDao.findUserById(id);
    }

    @Override
    public Integer updateUserState(User user) {
        return userDao.updateState(user);
    }

    @Override
    public void deleteByUserId(Integer id) {
        userDao.deleteUserById(id);
    }

}

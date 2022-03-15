package com.example.demo.dao;

//import com.example.demo.pojo.Category;
import com.example.demo.pojo.Toy;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //查找用户
    User findUser(@Param("username") String username,@Param("password") String password);
    //添加用户
    public Integer addUser(User user);
    User findUserByName(@Param("username") String username);
    //修改信息
    Integer editUser(User user);
    //用户名模糊查询
    List<User> Search(String username);
    //找到所有用户
    List<User> findAll();
    //通过id找用户
    User findUserById(@Param("id") Integer id);
    //根据用户id修改状态
    public int updateState(User user);
    //根据id删除用户
    public void deleteUserById(Integer id);
}

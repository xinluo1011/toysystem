package com.example.demo.dao;

import com.example.demo.pojo.Toy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToyDao {
    //根据用户找出玩具
    List<Toy> getToysByUser(Integer id);
    //根据分类找出玩具
    List<Toy> getToysByCid(Integer cid);
    //找到所有的玩具
    List<Toy> findAll();
    //添加玩具
    int addToy(Toy toy);
    //通过id删除玩具
    void deleteById(Integer toyid);
    //通过用户id删除玩具
    void deleteByUserId(Integer id);
    //修改玩具根据id
    int editToy(Toy toy);
    //根据id找出玩具
    Toy getToysById(Integer toyid);
    //Toy名的模糊查询
    List<Toy> Search(String name);
}

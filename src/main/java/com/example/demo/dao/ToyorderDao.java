package com.example.demo.dao;

import com.example.demo.pojo.Toyorder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToyorderDao {
    //新建订单
    public Integer addOrder(Toyorder toyOrder);
    //根据买家id找订单
    public List<Toyorder>  findByBid(@Param("bname") String bname);
    //根据卖家id找订单
    public List<Toyorder> findBySid(Integer sid);
}

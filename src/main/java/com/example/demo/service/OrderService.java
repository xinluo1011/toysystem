package com.example.demo.service;

import com.example.demo.pojo.Toyorder;

import java.util.List;

public interface OrderService {
    public Integer addOrder(Toyorder order);
    public List<Toyorder> findByBid(String bname);
    public List<Toyorder> findBySid(Integer sid);
}

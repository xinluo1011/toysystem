package com.example.demo.service.impl;

import com.example.demo.dao.ToyorderDao;
import com.example.demo.pojo.Toyorder;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ToyorderDao toyorderDao;

    @Override
    public Integer addOrder(Toyorder order) {
        return toyorderDao.addOrder(order);
    }

    @Override
    public List<Toyorder> findByBid(String bname) {
        return toyorderDao.findByBid(bname);
    }

    @Override
    public List<Toyorder> findBySid(Integer sid) {
        return toyorderDao.findBySid(sid);
    }
}

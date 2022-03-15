package com.example.demo.controller;

import com.example.demo.pojo.Toyorder;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @CrossOrigin
    @PostMapping("/addorder")
    public String addOrder(@RequestBody Toyorder order){
        int i=orderService.addOrder(order);
        if(i==0){
            return "error";
        }else{
            return "success";
        }
    }

    @ResponseBody
    @CrossOrigin
    @GetMapping("/bid/{bname}/order")
    public List<Toyorder> findByBid(@PathVariable("bname") String bname){
        if(bname!=null){
            return orderService.findByBid(bname);
        }else{
            return null;
        }
    }

    @ResponseBody
    @CrossOrigin
    @GetMapping("/sid/{sid}/order")
    public List<Toyorder> findBySid(@PathVariable("sid") int sid){
        if(0!=sid){
            return orderService.findBySid(sid);
        }else {
            return null;
        }
    }
}

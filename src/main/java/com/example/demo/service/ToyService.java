package com.example.demo.service;

import com.example.demo.pojo.Toy;

import java.util.List;

public interface ToyService {
    public List<Toy> list();
    public Integer addToy(Toy toy);
    public Integer editToy(Toy toy);
    public void deleteById(Integer toyid);
    public void  deleteByUserId(Integer id);
    public List<Toy> listByCategory(Integer cid);
    public List<Toy> listByUser(Integer id);
    public Toy findToyById(Integer toyid);
    public List<Toy> Search(String keywords);
}

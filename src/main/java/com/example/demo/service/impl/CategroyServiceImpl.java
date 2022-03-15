//package com.example.demo.service.impl;
//
////import com.example.demo.dao.CategoryDao;
////import com.example.demo.pojo.Category;
////import com.example.demo.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CategroyServiceImpl implements CategoryService {
//
//    @Autowired
//    CategoryDao categoryDao;
//
//    //对查询的结果进行了排序
//    @Override
//    public List<Category> list() {
//        Sort sort =Sort.by(Sort.Direction.DESC,"id");
//        return categoryDao.findAll(sort);
//    }
//
//    @Override
//    public Category get(Integer id) {
//        Category c=categoryDao.findById(id);
//        return c;
//    }
//}

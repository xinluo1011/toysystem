package com.example.demo.service.impl;

import com.example.demo.dao.ToyDao;
//import com.example.demo.pojo.Category;
import com.example.demo.pojo.Toy;
import com.example.demo.pojo.User;
//import com.example.demo.service.CategoryService;
import com.example.demo.service.ToyService;
import com.example.demo.service.UserService;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyServiceImpl implements ToyService {

    @Autowired
    ToyDao toyDao;

//    @Autowired
//    CategoryService categoryService;

    @Autowired
    UserService userService;
    /**
     * 查出所有玩具
     * @return 玩具（List）
     */
    @Override
    public List<Toy> list() {
        return toyDao.findAll();
    }

    @Override
    public Integer addToy(Toy toy) {
        return toyDao.addToy(toy);
    }

    @Override
    public Integer editToy(Toy toy) {
        return toyDao.editToy(toy);
    }

    /**
     * 通过玩具id删除玩具
     * @param toyid 玩具id
     */
    @Override
    public void deleteById(Integer toyid) {
        toyDao.deleteById(toyid);
    }

    @Override
    public void deleteByUserId(Integer id) {
        toyDao.deleteByUserId(id);
    }

    @Override
    public List<Toy> listByCategory(Integer cid) {
        return toyDao.getToysByCid(cid);
    }


//    @Override
//    public List<Toy> listByCategory(Integer cid) {
//       return toyDao.getToys(cid);
//    }

    @Override
    public List<Toy> listByUser(Integer id) {
        return toyDao.getToysByUser(id);
    }

    @Override
    public Toy findToyById(Integer toyid) {
        return toyDao.getToysById(toyid);
    }

    @Override
    public List<Toy> Search(String keywords) {
        return toyDao.Search(keywords);
    }

}

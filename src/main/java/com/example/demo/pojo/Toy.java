package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Toy {
    Integer toyid;//玩具id
    String name;//玩具名
    Integer price;//玩具价格
    String photo;//玩具图片
    Integer cid;//分类id
    Integer id;//用户id

    public Toy() {

    }

    public Toy(Integer toyid, String name, Integer price, String photo, Integer cid, Integer id) {
        this.toyid = toyid;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.cid = cid;
        this.id = id;
    }

    public Integer getToyid() {
        return toyid;
    }

    public void setToyid(Integer toyid) {
        this.toyid = toyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "toyid=" + toyid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", cid=" + cid +
                ", id=" + id +
                '}';
    }
}

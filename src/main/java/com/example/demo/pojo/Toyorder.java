package com.example.demo.pojo;

public class Toyorder {
    Integer oid;//订单id
    Integer tid;//玩具id
    String name;//玩具名
    Integer price;//玩具价格
    String bname;//买家id
    Integer sid;//卖家id

    public Toyorder() {
    }

    public Toyorder(Integer oid, Integer tid, String name, Integer price, String bname, Integer sid) {
        this.oid = oid;
        this.tid = tid;
        this.name = name;
        this.price = price;
        this.bname = bname;
        this.sid = sid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Toyorder{" +
                "oid=" + oid +
                ", tid=" + tid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", bname='" + bname + '\'' +
                ", sid=" + sid +
                '}';
    }
}

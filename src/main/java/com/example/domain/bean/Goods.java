package com.example.domain.bean;

/**
 * @ClassName Goods
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/4/23 12:21
 * @Version 1.0
 **/
public class Goods {
    private int id;
    private String name;
    private Double price;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Goods() {
    }

    public Goods(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

package com.example.domain.bean;

/**
 * @ClassName ShopCar
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/4/23 15:36
 * @Version 1.0
 **/
public class ShopCar {
    private Goods goods;
    private int number;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

package com.example.domain.bean;

/**
 * @ClassName GoodsDao
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/4/23 12:18
 * @Version 1.0
 **/
public class ShopUser {
    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "ShopUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

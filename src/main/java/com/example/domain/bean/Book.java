package com.example.domain.bean;

/**
 * @ClassName Book
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/3/25 12:02
 * @Version 1.0
 **/
public class Book {
    private int id;
    private String name;
    private String author;
    private Double money;

    public Book() {
    }

    public Book(int id, String name, String author, Double money) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", money=" + money +
                '}';
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}

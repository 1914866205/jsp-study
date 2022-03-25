package com.example.domain.bean;


import java.sql.Date;

/**
 * @ClassName Person
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/3/25 11:47
 * @Version 1.0
 **/
public class Person {

    int pid;
    String name;
    int age;
    Date birthday;
    double salary;

    public Person(int pid, String name, int age, Date birthday, double salary) {
        this.pid = pid;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.salary = salary;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

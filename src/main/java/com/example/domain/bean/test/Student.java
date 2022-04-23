/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.domain.bean.test;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * VO    类-表；  类的对象---一行记录     ORM  Object Relation Map
 */
public class Student {
    private int id;
    private String name;
    private Date birthday;
    private float score;
    private String major;
    private String telphone;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }    
    
    public void print(){
       SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
       String birthdayStr = sdf.format(birthday);
       System.out.printf("%5s%8s%15s%8.1f%12s%15s%n", 
               id, name, birthdayStr, score,major,telphone); 
    }    
    public static void printHeader(){
        System.out.printf("%5s%8s%15s%8s%12s%15s%n", "ID", "Name", "Birthday", "Score","Major","Telphone");
    }
}

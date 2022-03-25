package com.example.domain.bean;

/**
 * @ClassName Student
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/3/25 16:58
 * @Version 1.0
 **/
public class Student {
    private int id;
    private String name;
    private double usualPer;
    private double experPer;
    private double endPer;
    private double totalPer;

    public Student() {
    }

    public Student(int id, String name, double usualPer, double experPer, double endPer) {
        this.id = id;
        this.name = name;
        this.usualPer = usualPer;
        this.experPer = experPer;
        this.endPer = endPer;
        setTotalPer(usualPer,experPer,endPer);
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

    public double getUsualPer() {
        return usualPer;
    }

    public void setUsualPer(double usualPer) {
        this.usualPer = usualPer;
    }

    public double getExperPer() {
        return experPer;
    }

    public void setExperPer(double experPer) {
        this.experPer = experPer;
    }

    public double getEndPer() {
        return endPer;
    }

    public void setEndPer(double endPer) {
        this.endPer = endPer;
    }

    public void setTotalPer(double usualPer, double experPer, double endPer) {
        this.totalPer=usualPer * 0.1 + experPer * 0.2 + endPer * 0.7;
    }

    public double getTotalPer() {
        return totalPer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", usualPer=" + usualPer +
                ", experPer=" + experPer +
                ", endPer=" + endPer +
                ", totalPer=" + totalPer +
                '}';
    }
}

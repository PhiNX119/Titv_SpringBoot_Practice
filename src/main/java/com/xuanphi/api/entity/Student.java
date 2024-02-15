package com.xuanphi.api.entity;

public class Student {
    private int id;
    private String fullName;
    private int age;
    private String major;
    private double mark;

    public Student() {
    }

    public Student(int id, String fullName, int age, String major, double mark) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.major = major;
        this.mark = mark;
    }

    //Jackson

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}

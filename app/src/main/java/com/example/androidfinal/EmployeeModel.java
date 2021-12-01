package com.example.androidfinal;

public class EmployeeModel {

    private int id;
    private int age;
    private String name;
    private boolean isActive;

    public EmployeeModel(int id, String name, int age, boolean isActive)
    {
        this.id=id;
        this.name=name;
        this.age = age;
        this.isActive=isActive;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return
                "ID: " + getId() +
                ", Age: " + getAge() +
                ", Name: " + getName() +
                ", Is Active: " + isActive();
    }
}

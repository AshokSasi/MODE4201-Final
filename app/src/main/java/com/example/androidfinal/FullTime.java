package com.example.androidfinal;

public class FullTime extends Employee {

    private int salary;
    private int bonus;

    public FullTime(String empID, String firstName, String lastName, int birthYear, int salary, int bonus) {
        super(empID, firstName, lastName, birthYear);
        this.salary = salary;
        this.bonus = bonus;
    }

    public FullTime() {
        super();
        salary = 0;
        bonus = 0;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int calcEarnings() {
        return getSalary() + getBonus();
    }

    @Override
    public String toString() {
        return super.toString() + ", Full Time";
    }
}

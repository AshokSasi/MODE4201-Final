package com.example.androidfinal;

public class PartTime extends Employee {

    private int hoursWorked;
    private int rate;


    public PartTime(String empID, String firstName, String lastName, int birthYear, int hoursWorked, int rate) {
        super(empID, firstName, lastName, birthYear);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    public PartTime() {
        super();
        hoursWorked = 0;
        rate = 0;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


    @Override
    public String toString() {
        return super.toString() + ", Part Time";
    }

    @Override
    public int calcEarnings() {
        return this.hoursWorked * this.rate;
    }
}

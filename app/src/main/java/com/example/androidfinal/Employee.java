package com.example.androidfinal;

public abstract class Employee {

    private String empID;
    private String firstName;
    private String lastName;
    private int birthYear;

    public Vehicle vRef;

    public Employee(String empID, String firstName, String lastName, int birthYear, Vehicle vRef) {
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.vRef = vRef;
    }

    public Employee(String empID, String firstName, String lastName, int birthYear) {
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.vRef = null;
    }

    public Employee() {
        empID = "";
        firstName = "";
        lastName = "";
        birthYear = 0;
        vRef = null;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public abstract int calcEarnings();

    public int calcAge() {
        return 2021 - this.birthYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID='" + getEmpID() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", birthYear=" + getBirthYear() +
                '}';
    }
}

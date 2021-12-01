package com.example.androidfinal;

public class Vehicle {

    private String make;
    private String plateNumber;

    public Vehicle(String make, String plateNumber) {
        this.make = make;
        this.plateNumber = plateNumber;
    }

    public Vehicle() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}

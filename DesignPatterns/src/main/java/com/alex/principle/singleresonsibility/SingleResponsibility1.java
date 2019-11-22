package com.alex.principle.singleresonsibility;

public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
    }
}

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上航行*******");
    }
}
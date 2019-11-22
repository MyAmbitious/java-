package com.alex.prototype.sheep;

import com.alex.prototype.improve.Sheep;

public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("alex",45,"white");
        final Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        System.out.println(sheep);
        System.out.println(sheep1);
    }
}

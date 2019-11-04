package com.alex.googleguava.comparisonchain;

public class ComparisonChainDemo {
    public static void main(String[] args) {

        Person person = new Person("alex",24,170);
        Person person2 = new Person("alex",24,170);
        Person person3 = new Person("alex",25,170);
        // System.out.println(Objects.equal("a", "a"));
        System.out.println(person.equals(person2));
        System.out.println(person2);
    }
}

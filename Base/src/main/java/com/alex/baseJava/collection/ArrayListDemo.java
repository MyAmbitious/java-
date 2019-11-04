package com.alex.baseJava.collection;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(450);
        for(int i =0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
}

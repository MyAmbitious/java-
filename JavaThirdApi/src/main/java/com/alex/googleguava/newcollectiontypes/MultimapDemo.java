package com.alex.googleguava.newcollectiontypes;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;

public class MultimapDemo {
    public static void main(String[] args) {
        // creates a ListMultimap with tree keys and array list values
        ListMultimap<String, Integer> treeListMultimap =
                MultimapBuilder.treeKeys().arrayListValues().build();
        treeListMultimap.put("dsa",45);
        treeListMultimap.put("dsa",47);
        System.out.println(treeListMultimap);
    }
}

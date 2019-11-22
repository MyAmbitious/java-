package com.alex.prototype.deepclone;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype p = new DeepPrototype();
        p.name = "alex";
        p.deepCloneableTarget = new DeepCloneableTarget("大傻", "大傻的类");

    //    方式1 完成深拷贝
        DeepPrototype p2 = (DeepPrototype)p.clone();
        System.out.println("p.name = "+p.name+" p.deepCloneableTarget ="+p.deepCloneableTarget.hashCode());
        System.out.println("p.name = "+p2.name+" p.deepCloneableTarget ="+p2.deepCloneableTarget.hashCode());

    //    序列化反序列化完成深拷贝
        DeepPrototype p3 = (DeepPrototype)p.deepClone();
        System.out.println("p.name = "+p.name+" p.deepCloneableTarget ="+p.deepCloneableTarget.hashCode());
        System.out.println("p.name = "+p3.name+" p.deepCloneableTarget ="+p3.deepCloneableTarget.hashCode());
    }
}

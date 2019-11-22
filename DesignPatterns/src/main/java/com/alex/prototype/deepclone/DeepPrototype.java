package com.alex.prototype.deepclone;

import java.io.*;

public class DeepPrototype implements Serializable, Cloneable {
    public String name;//基本类型
    public DeepCloneableTarget deepCloneableTarget;//引用类型

    public DeepPrototype() {
        super();
    }

    // 使用clone方法实现深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //这里完成对基本数据类型（属性）和String的克隆
        deep = super.clone();
        //对引用类型的属性 进行单独处理
        DeepPrototype deepPrototype = (DeepPrototype) deep;
        deepPrototype.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();

        return deepPrototype;
    }

    //    通过对象的序列化实现深克隆（推荐）
    public Object deepClone() {
        //    创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//当前这个对象以对象刘的方式输出

            //    反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            final DeepPrototype copyObj = (DeepPrototype) ois.readObject();
            return copyObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

package com.alex.baseJava.genericparadigm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
//泛型带来的好处
// 将运行时期的ClassCastException，转移到了编译时期 变成了编译失败。
//避免了类型强转的麻烦。
public class GenericDemo2 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("itcast");
        // list.add(5);//当集合明确类型后，存放类型不一致就会编译报错
        // 集合已经明确具体存放的元素类型，那么在使用迭代器的时候，迭代器也同样会知道具体遍历元素类型
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            //当使用Iterator<String>控制元素类型后，就不需要强转了。获取到的元素直接就是String类型
            System.out.println(str.length());
        }
    }
}

package com.alex.baseJava.genericparadigm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//Collection虽然可以存储各种对象，但实际上通常Collection只存储同一类型对象。例如都是存储字符串对象。因此在JDK5之后，
// 新增了**泛型**(**Generic**)语法，让你在设计API时可以指定类或
// 方法支持泛型，这样我们使用API的时候也变得更为简洁，并得到了编译时期的语法检查。


//泛型**：可以在类或方法中预支地使用未知的类型。
public class GenericDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add("itcast");
        coll.add(5);//由于集合没有做任何限定，任何类型都可以给其中存放
        Iterator it = coll.iterator();
        //会报错Exception in thread "main" java.lang.ClassCastException: java.base/java.lang.Integer cannot be cast to java.base/java.lang.String
        while(it.hasNext()){
            //需要打印每个字符串的长度,就要把迭代出来的对象转成String类型
            String str = (String) it.next();
            System.out.println(str.length());
        }
    }
}

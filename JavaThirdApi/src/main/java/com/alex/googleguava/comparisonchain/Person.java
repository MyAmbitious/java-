package com.alex.googleguava.comparisonchain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class Person implements Comparable<Person>{

    private String name;
    private int age;
    private double high;

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, double high) {
        this.name = name;
        this.age = age;
        this.high = high;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("age", age)
                .add("high", high)
                .toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Double.compare(person.high, high) == 0 &&
                Objects.equal(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age, high);
    }

    //使用ComparisonChain来重写排序的规则
    @Override
    public int compareTo(Person o) {
        //return 0;//认为元素都是相同的
        //自定义比较的规则,比较两个人的年龄(this,参数Person)
        //return this.getAge() - o.getAge();//年龄升序排序
        // return o.getAge() - this.getAge();//年龄降序排序
        return ComparisonChain.start()
                .compare(this.name,o.name)
                .compare(this.age,o.age)
                .compare(this.high,o.high)
                .result();
    }
}

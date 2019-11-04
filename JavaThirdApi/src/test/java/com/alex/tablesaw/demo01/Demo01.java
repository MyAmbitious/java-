package com.alex.tablesaw.demo01;

import org.junit.Test;
import tech.tablesaw.api.DoubleColumn;

public class Demo01 {

    @Test
    public void test01(){
        double[] numbers = {1, 2, 3, 4};
        DoubleColumn nc = DoubleColumn.create("nc", numbers);
        System.out.println(nc.print());
    }
}

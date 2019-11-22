package com.alex.adaper.objectadapter;

public class Phone {
    //手机充电
    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println("电压为5v,可以进行充电");
        } else if (iVoltage5V.output5V() > 5) {
            System.out.println("电压大于5v,不可以进行充电");
        }
    }
}

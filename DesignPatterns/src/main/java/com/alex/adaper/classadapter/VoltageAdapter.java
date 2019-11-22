package com.alex.adaper.classadapter;

public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        int srcV = output220V();
        int distV = srcV/44;//转成5v
        return distV;
    }
}

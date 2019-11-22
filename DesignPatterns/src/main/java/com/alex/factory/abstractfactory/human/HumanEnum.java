package com.alex.factory.abstractfactory.human;

public enum HumanEnum {
    //把世界上所有人类型都定义出来
    YelloMaleHuman("YellowFemaleHuman"),
    YelloFemaleHuman("YellowFemaleHuman"),
    WhiteFemaleHuman("WhiteFemaleHuman"),
    WhiteMaleHuman("WhiteMaleHuman"),
    BlackFemaleHuman("BlackFemaleHuman"),
    BlackMaleHuman("BlackMaleHuman");
    private String data = "";

    //定义构造函数，目的是Data(value)类型的相匹配
    private HumanEnum(String value) {
        this.data = value;
    }

    public String getValue() {
        return this.data;
    }
}
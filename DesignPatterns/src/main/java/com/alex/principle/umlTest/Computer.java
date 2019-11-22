package com.alex.principle.umlTest;

public class Computer {
    private Keyboard keyboard = new Keyboard();
     private Monitor  monitor1 = new Monitor();
    private Monitor  monitor;

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}

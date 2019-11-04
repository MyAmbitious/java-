package com.alex.baseJava.threads.demo10.WaitAndNotify;

public class Demo3 {
    public static void main(String[] args) {
        // new Thread(new ChiHuo("大傻",new BaoZi())).start();
        // new Thread(new BaoZiPu("大傻",new BaoZi())).start();

        //等待唤醒案例
        BaoZi bz = new BaoZi();

        ChiHuo ch = new ChiHuo("吃货",bz);
        BaoZiPu bzp = new BaoZiPu("包子铺",bz);

        ch.start();
        bzp.start();

    }
}

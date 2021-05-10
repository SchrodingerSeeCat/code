package com.valid.adapter.objectadapter;

public class Phone {
    public void charging(Voltage5V v) {
        if (v.output5V() == 5) {
            System.out.println("可以充电了");
            return;
        }
        if (v.output5V() > 5 ) {
            System.out.println("电压大于5V不能充电");
        }
    }
}

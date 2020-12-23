package org.valid.service;

public class WxPay implements PayService {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}

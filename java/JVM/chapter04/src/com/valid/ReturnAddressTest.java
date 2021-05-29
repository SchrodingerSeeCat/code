package com.valid;

public class ReturnAddressTest {
    public void methodA() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

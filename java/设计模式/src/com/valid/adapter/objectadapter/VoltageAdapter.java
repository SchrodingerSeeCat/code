package com.valid.adapter.objectadapter;

// 适配器
public class VoltageAdapter implements Voltage5V{
    private final Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dist = 0;
        if (voltage220V != null) {
            int src = voltage220V.output220V(); // 获取原本的结果
            dist = src / 44;    // 处理转换
            return dist;
        }
        return dist;
    }
}

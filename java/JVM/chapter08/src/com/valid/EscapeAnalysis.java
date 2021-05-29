package com.valid;

public class EscapeAnalysis {
    private EscapeAnalysis obj;

    public EscapeAnalysis getInstance() {
        // 发生逃逸
        return obj == null ? new EscapeAnalysis() : obj;
    }

    public void setObj() {
        // 发生逃逸
        this.obj = new EscapeAnalysis();
    }

    public void useEscapeAnalysis1() {
        // 没有发生逃逸
        EscapeAnalysis e = new EscapeAnalysis();
    }

    public void useEscapeAnalysis2() {
        // 发生逃逸
        EscapeAnalysis e = getInstance();
    }
}

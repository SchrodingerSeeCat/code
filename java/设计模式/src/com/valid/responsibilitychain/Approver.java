package com.valid.responsibilitychain;

public abstract class Approver {
    protected Approver approver; // 下一个处理者
    protected String name;        // 名字

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    // 处理请求的方法
    public abstract void processRequest(PurchaseRequest request);
}

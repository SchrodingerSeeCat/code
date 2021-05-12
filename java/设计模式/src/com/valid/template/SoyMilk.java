package com.valid.template;

public abstract class SoyMilk {
    public void make() {
        select();
        if (isAdd()) {
            add();
        }
        soak();
        beat();
    }

    private void select() {
        System.out.println("选材料");
    }

    // 添加配料
    public abstract void add();

    private void soak() {
        System.out.println("浸泡");
    }

    private void beat() {
        System.out.println("豆浆机打豆浆");
    }

    // 钩子方法，决定是否需要添加配料
    public boolean isAdd() {
        return true;
    }
}

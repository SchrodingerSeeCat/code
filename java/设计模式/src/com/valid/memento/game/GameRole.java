package com.valid.memento.game;

public class GameRole {
    private int vit;
    private int def;

    // 创建备忘录
    public Memento createMemento() {
        return new Memento(vit, def);
    }

    // 恢复备忘录
    public void recover(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }

    // 显示状态
    public void display() {
        System.out.println("攻击力: " + vit);
        System.out.println("防御力: " + def);
    }

    public int getVit() {
        return vit;
    }

    public int getDef() {
        return def;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public void setDef(int def) {
        this.def = def;
    }
}

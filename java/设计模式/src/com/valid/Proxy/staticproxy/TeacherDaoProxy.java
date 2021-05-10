package com.valid.Proxy.staticproxy;

public class TeacherDaoProxy implements ITeacherDao{
    // 目标对象
    private final ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("代理开始....");
        target.teach();
        System.out.println("代理结束....");
    }
}

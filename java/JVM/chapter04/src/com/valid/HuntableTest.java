package com.valid;

public class HuntableTest {
    public void test(Huntable huntable) {
        huntable.hunt(); // 晚期绑定
    }
}


class Dog implements Huntable {
    @Override
    public void hunt() {
        System.out.println("狗吃骨头");
    }
}
class Cat extends Animal implements Huntable {

    @Override
    public void hunt() {
        System.out.println("猫吃鱼");
    }
}


class Animal {
    public static void test() {

    }
}
interface Huntable{
    void hunt();
}
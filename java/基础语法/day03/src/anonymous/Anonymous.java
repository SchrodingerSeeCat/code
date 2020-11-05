package anonymous;

// 匿名类

public class Anonymous {
    public static void main(String[] args) {
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("人能吃饭");
            }
        };
        p.eat();
    }
}

abstract class Person{
    public abstract void eat();
}

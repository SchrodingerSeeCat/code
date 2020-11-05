package Internalclass;

// 内部类
public class InnerClassTest {
    public static void main(String[] args) {
        // 创建静态内部类的实例
        Animal.Bird bird = new Animal.Bird();
        bird.sing();

        // 创建非静态的内部类实例
        Animal animal = new Animal();
        Animal.Dog dog = animal.new Dog();
        dog.bark();
    }
}
class Animal{
    String name = "Animal";
    // 外部类的结构
    public void eat(){
        System.out.println("动物会吃饭");
    }


    // 成员内部类：可以定义属性、方法、构造器，可以被`final`修饰，可以被`abstract`修饰
    // 成员内部类
    class Dog{
        String name;
        public void bark(){
            System.out.println("汪汪汪");
        }
        public void display(String name){
            System.out.println(name); //方法的形参
            System.out.println(this.name); // 内部类的属性
            System.out.println(Animal.this.name); // 外部类的属性
        }
    }

    // 静态成员内部类
    static class Bird{
        String name;
        public void sing(){
            System.out.println("吱吱吱");
        }
    }
}

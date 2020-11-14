package codeblock;

// 代码块
public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        Person p1 = new Person();
    }
}

class Person{
    // 属性
    String name;
    int age;
    static String desc = "I am a man";

    // static的代码块
    static{
        System.out.println("Hello, I am a static code block");
    }
    {
        System.out.println("Hello, I am a code block");
    }


    // 构造器
    public Person(){

    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("吃饭");
    }
    public String toString() {
        return "Person [name=" + name + ", age=" + "]";
    }
}
package abstracttest;

// abstract的使用

public class AbstractTest {
    public static void main(String[] args) {

    }
}
abstract class Person{
    String name;
    int age;
    public Person(){

    }
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public abstract void eat();
}
class Student extends Person {
    public Student(int age, String name) {
        super(age, name);
    }
    public void eat() {

    }
}
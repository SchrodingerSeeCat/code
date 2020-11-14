package reflectstruct;

import java.util.Random;

@MyAnnotation(value = "class")
public class Person extends Creature<String> implements Comparable<String>, MyInterface{

    private String name;
    int age;
    public int id;

    public Person(){
        id = new Random().nextInt(100);
    }

    @MyAnnotation(value = "constructor")
    private Person(String name) {
        this();
        this.name = name;
    }

    Person(String name, int age) {
        this(name);
        this.age = age;
    }

    @MyAnnotation(value = "method")
    private String show(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String skill(String skill) throws Exception {
        return skill;
    }
    @Override
    public int compareTo(String o) {
        return name.compareTo(o);
    }

    @Override
    public void info() {
        System.out.println("I am a Person");
    }
}

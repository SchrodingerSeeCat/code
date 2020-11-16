package com.wanliding;

public class Person {
    private int age;
    private String name;
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    // 重写equals指定相等的规则
    public boolean equals(Object obj){
        if (obj instanceof Person) {
            Person person = (Person)obj;
            return this.age == person.age && this.name.equals(person.name);
        }
        return false;
    }

    // 重写toString()
    public String toString(){
        return "Person(" + "name = " + name + " age = " + age + ")";
    }
}

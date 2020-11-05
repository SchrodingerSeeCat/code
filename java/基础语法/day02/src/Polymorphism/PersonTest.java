package Polymorphism;

import Polymorphism.Man;
import Polymorphism.Person;

public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Man();
        Person p2 = new Woman();

        p1.eat();
        p2.eat();
    }
}

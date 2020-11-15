package endoperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static List<Person> getPersons(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("Tom", 18));
        list.add(new Person("Jack", 56));
        list.add(new Person("Alice", 18));
        list.add(new Person("Bob", 38));
        list.add(new Person("Tony", 22));
        list.add(new Person("Stark", 14));
        return list;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
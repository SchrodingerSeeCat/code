package equals;

public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Person(20, "小明");
        Person p2 = new Person(20, "老王");
        System.out.println(p1.equals(p2));
    }
}

class Person{
    int age;
    String name;
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && this.name.equals(person.name);
    }
}

package toString;

public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Person(20, "小明");
        System.out.println(p1.toString());
    }
}

class Person{
    int age;
    String name;
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    public String toString(){
        return "Person[name=" + this.name + ", age=" + this.age + "]";
    }
}

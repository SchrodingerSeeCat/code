package ReflectionTest;

public class Person{
    private String name;
    public int age;

    public Person(){}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("I am " + name);
    }

    private String showNation(String nation) {
        System.out.println("My nation is " + nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Person implements Comparable<Person>{
    private int age;
    public Person(int age) {
        this.age = age;
    }
    // 获得年龄
    public int getAge(){
        return age;
    }
    //

    // 实现比较的接口
    public int compareTo(Person e) {
        return this.age - e.age;
    }

    // 打印Person
    public String toString(){
        return "Person_age = " + age;
    }
}

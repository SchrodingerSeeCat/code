// 设计类就是设计类的成员
public class PersonTest {
    public static void main(String[] args) {
        // 创建类的对象 = 类的实例化 = 实例化类
        Person p1 = new Person(10);
        p1.name = "Tom";
    }
}
class Person{
    // 属性(成员变量)
    String name;
    int age = 1;
    boolean isMale;
    public Person(){
        System.out.println("qwer");
    }
    public Person(int age) {
        this.age = age;
    }
    // 方法
    public void eat(){
        System.out.println("人可以吃饭");
    }

    public void sleep(){
        System.out.println("人可以睡觉");
    }

    public void talk(String language){
        System.out.println("人可以说话, 使用的是：" + language);
    }
}
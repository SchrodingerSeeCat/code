package interfacetest;

// JDK8的接口
public class JDK8Interface {

    // 接口中定义的静态方法，只能通过接口来调用
    public static void main(String[] args) {
        Interface.method1();

        SubClass s = new SubClass();
        s.method2();
    }
}
class SubClass implements Interface{

}

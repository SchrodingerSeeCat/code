package interfacetest;

// 接口
public class InterfaceTest {

}

interface Flyable{
    // 全局常量
    public static final int MAX_SPEED = 7900;
    // int MAX_SPEED = 7900; 可以省略public static final

    // 抽象方法
    public abstract void fly();
    // void fly(); 可以省略public abstract

}

// 可以通过类实现接口
class Plane implements Flyable{
    public void fly(){

    }
}

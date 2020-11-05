package interfacetest;

public interface Interface{

    // 静态方法
    public static void method1(){
        System.out.println("JDK8可以有方法体");
    }

    // 默认方法
    public default void method2(){
        System.out.println("JDK8默认方法");
    }
}

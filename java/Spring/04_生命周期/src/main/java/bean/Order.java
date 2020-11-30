package bean;

public class Order {
    private String name;

    public Order(){
        System.out.println("1.调用的无参构造");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2.调用set方法");
    }

    // 创建执行初始化的方法
    public void init(){
        System.out.println("3.调用初始化方法");
    }

    // 创建销毁时执行的方法
    public void destroy(){
        System.out.println("5.执行销毁的方法");
    }
}

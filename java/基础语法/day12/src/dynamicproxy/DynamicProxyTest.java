package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    String getBelief();
    void eat(String food);
}


public class DynamicProxyTest {
    public static void main(String[] args) {
        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(new SuperMan());
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("掉渣饼");
    }
}
// 代理类
class ProxyFactory<E>{
    // 调用此方法，返回一个代理类对象 obj为被代理类的对象
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj; // 需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }
    // 当通过代理类的对象，调用方法时，就会自动调用 invoke
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method是代理类对象调用的方法，也是被代理类对象要调用的方法
        return method.invoke(obj, args);
    }
}

// 被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "保护地球";
    }

    @Override
    public void eat(String food) {
        System.out.println("超人吃" + food);
    }
}

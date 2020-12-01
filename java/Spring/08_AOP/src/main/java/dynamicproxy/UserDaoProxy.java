package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UserDaoProxy implements InvocationHandler {
    // 1. 通过有参构造传递被代理类的对象
    private Object obj;
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    // 增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法之前
        System.out.println("方法之前执行：" + method.getName() + " :传递的参数：" + Arrays.toString(args));

        // 被增强的方法执行
        Object res = method.invoke(obj, args);

        // 方法之后
        System.out.println("方法之后执行");
        return res;
    }
}

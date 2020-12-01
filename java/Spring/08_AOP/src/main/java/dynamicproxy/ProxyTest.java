package dynamicproxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        // 创建接口实现类的代理对象
        Class[] interfaces = {User.class};
        UserImpl user = new UserImpl();
        User u = (User)Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), interfaces, new UserDaoProxy(user));
        System.out.println(u.add(1, 2));;
    }
}

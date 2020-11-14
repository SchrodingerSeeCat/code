package getstruct;

import org.junit.Test;
import reflectstruct.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
*
* 获取方法结构
* */
public class GetMethodTest {
    @Test
    public void test() {
        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getMethods();

        for(Method m : methods) {
            System.out.println(m);
        }

        System.out.println();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods) {
            System.out.println(m);
        }
    }

    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        // 获取方法声明的注解
        for(Method m : declaredMethods) {
            Annotation[] annos = m.getAnnotations();
            for(Annotation a : annos) {
                System.out.println(a + " ");
            }

            // 获取权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + " ");

            // 返回值类型
            System.out.print(m.getReturnType() + " ");

            // 方法名
            System.out.print(m.getName() + " ( ");

            // 形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(parameterTypes != null && parameterTypes.length != 0) {
                for(Class param : parameterTypes) {
                    System.out.print(param + " ");
                }
            }
            System.out.print(") ");

            // 抛出的异常
            Class[] exceptions = m.getExceptionTypes();
            if (exceptions != null && exceptions.length != 0) {
                System.out.print("throws ");
                for(Class e : exceptions) {
                    System.out.print(e);
                }
            }

            System.out.println();
        }
    }
}

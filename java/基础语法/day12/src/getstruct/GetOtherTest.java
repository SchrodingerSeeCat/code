package getstruct;

import org.junit.Test;
import reflectstruct.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GetOtherTest {
    @Test
    public void test() {
        // 获取构造器
        Class<Person> clazz = Person.class;
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor con : constructors) {
            System.out.println(con);
        }
        System.out.println();

        Constructor[] constructors1 = clazz.getDeclaredConstructors();
        for(Constructor con : constructors1) {
            System.out.println(con);
        }
    }

    @Test
    public void test1() {
        // 获取运行时类的父类
        Class clazz = Person.class;
        
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);

        // 获取带泛型的父类
        Type superClass1 = clazz.getGenericSuperclass();
        System.out.println(superClass1);

        // 获取带泛型的父类的泛型
        Type superClass2 = clazz.getGenericSuperclass();
        ParameterizedType ptt = (ParameterizedType)superClass2;
        Type[] args = ptt.getActualTypeArguments();
        for(Type a : args) {
            System.out.println(a);
        }
    }

    @Test
    public void test2() {
        // 获取运行时类实现的接口
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for(Class in : interfaces) {
            System.out.println(in);
        }

        // 获取运行时类所在的包
        Package pack = clazz.getPackage();
        System.out.println(pack);

        // 获取运行时类的注解
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

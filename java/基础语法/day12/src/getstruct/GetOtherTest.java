package getstruct;

import org.junit.Test;
import reflectstruct.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/*
* 调用其它的结构
* */
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

    @Test
    public void test3() throws Exception {
        // 获取运行时类中声明为public属性的方法
        Class<Person> clazz = Person.class;
        Field id = clazz.getField("id");
        System.out.println(id);

        // 设置属性的值
        Person p = clazz.getConstructor().newInstance();
        id.set(p, 1001);
        System.out.println(id.get(p));
    }

    @Test
    public void test4() throws Exception{
        // 获取运行时类中任意属性
        Class<Person> clazz = Person.class;
        Person p = clazz.getConstructor().newInstance();

        Field name = clazz.getDeclaredField("name");
        // 保证当前属性是可访问的
        name.setAccessible(true);
        name.set(p, "Tom");
        System.out.println(name.get(p));
    }

    @Test
    public void test5() throws Exception{
        // 操作运行类中的指定方法
        Class<Person> clazz = Person.class;
        Person p = clazz.getConstructor().newInstance();

        // 获取指定的某个方法
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        String returnValue = (String)show.invoke(p, "China");
        System.out.println(returnValue);

        // 调用静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        showDesc.invoke(Person.class);
    }

    @Test
    public void test6() throws Exception{
        // 调用构造器
        Class clazz = Person.class;

        // 获取指定的构造器
        Constructor<Person> pc = clazz.getDeclaredConstructor(String.class);

        // 保证此构造器是可访问的
        pc.setAccessible(true);

        // 创建对象
        Person tom = pc.newInstance("Tom");
        System.out.println(tom);

    }
}

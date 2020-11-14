package ReflectionTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest {
    @Test
    public void test() throws Exception {
        // 反射创建Person对象
        // 拿到Person的class
        Class<Person> personClass = Person.class;
        // 得到Person的构造器
        Constructor<Person> cons = personClass.getConstructor(String.class, int.class);
        // 实例化Person对象
        Person p = cons.newInstance("Tom", 12);

        // 通过反射调用对象指定的属性方法
        Field age = personClass.getField("age");
        age.set(p, 10);

        // 调用方法
        Method show = personClass.getMethod("show");
        show.invoke(p);

        // 调用私有结构器
        Constructor<Person> cons1 = personClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p2 = cons1.newInstance("大黄");
        // 调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2, "大白");
        // 调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p2, "China");
        System.out.println(nation);

    }

    @Test
    public void test1() throws ClassNotFoundException {
        // 调用运行时类的属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        // 调用运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        // 调用Class的静态方法forName(String classPath)
        Class clazz3 = Class.forName("ReflectionTest.Person");
        System.out.println(clazz3);

        // 使用类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("ReflectionTest.Person");
        System.out.println(clazz4);
    }

    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();


//        读取配置文件的方式一
        // 文件默认在当前module下
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);
//        System.out.println("user = " + pros.getProperty("user") + "\npassword = " + pros.getProperty("password"));

//        读取配置文件的方式二
        // 文件默认路径在当前module下的src下
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(in);
        System.out.println("user = " + pros.getProperty("user") + "\npassword = " + pros.getProperty("password"));

    }
}



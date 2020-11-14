package ReflectionTest;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/*
* 通过反射创建对应的运行时类
* */
public class NewInstanceTest {
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        System.out.println(p);
    }

    @Test
    public void test1(){
        for(int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch(num) {
                case 1:
                    classPath = "java.util.Date";
                    break;
                case 2:
                    classPath = "java.lang.Object";
                    break;
                default:
                    classPath = "ReflectionTest.Person";
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getInstance(String classPath) throws Exception {
        return Class.forName(classPath).getConstructor().newInstance();
    }
}

package getstruct;

import org.junit.Test;
import reflectstruct.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
* 获取当前运行时类属性的结构
*
* */
public class GetFieldTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;

        // 获取所有public属性
//        Field[] fields = clazz.getFields();
//        for(Field f : fields) {
//            System.out.println(f);
//        }

        // 获取所有属性
        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields) {
            System.out.println(f);
        }
    }

    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields) {
            // 权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            // 数据类型
            Class type = f.getType();
            System.out.print(type + " ");
            // 变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}

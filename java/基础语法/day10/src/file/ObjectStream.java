package file;

import org.junit.Test;

import java.io.*;

public class ObjectStream {

    // 序列化
    @Test
    public void test(){
        // 1. 创建对象流
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            // 2. 写入对象
            oos.writeObject(new String("hello 中国"));
            oos.writeObject(new Person("Alice", 18));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 反序列化
    @Test
    public void test1(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            String str = (String) ois.readObject();
            Person person = (Person) ois.readObject();
            System.out.println(str);
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Person implements Serializable {
    private String name;
    private int age;
    public static final long serialVersionUID = 498464161223L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
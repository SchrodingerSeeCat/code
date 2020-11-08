package annotationtest;

import org.junit.Test;

import java.lang.annotation.*;
import java.util.ArrayList;

public class AnnotationTest {
    @Test
    public void test(){
        Class<Student> studentClass = Student.class;
        Annotation[] annotations = studentClass.getAnnotations();
        for(int i = 0; i < annotations.length; i++){
            System.out.println(annotations[i]);
        }
    }
    @Test
    public void test1(){
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int)10L;
    }
}

@MyAnnotation(value = "hello")
@MyAnnotation(value = "world")
class Person{

}
class Student extends Person{

}

class Animal<@MyAnnotation T> {

}

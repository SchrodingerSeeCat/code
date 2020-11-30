import factorybean.Course;
import model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        System.out.println(book1);
        System.out.println(book2);
    }
}

import aopanno.User;
import aopxml.Book;
import config.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AOPTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }

    @Test
    public void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User user = context.getBean("user", User.class);
        user.add();
    }
}

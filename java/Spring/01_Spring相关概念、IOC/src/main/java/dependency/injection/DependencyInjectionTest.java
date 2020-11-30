package dependency.injection;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DependencyInjectionTest {
    @Test
    public void test() {
        // 无参注入
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void test1() {
        // 有参注入
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println(order);
    }
}

class Book{
    private String bookName;
    private String bookAuthor;
    private String address;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Order{
    private String name;
    private String address;
    public Order(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
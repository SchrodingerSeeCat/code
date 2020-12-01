import entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

public class JDBCTest {
    @Test
    public void test() {
        // 测试JDBCTemplate的添加操作
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book();
        book.setUsername("叶凡");
        book.setStatus("失踪");
        bookService.addBook(book);
    }

    @Test
    public void test1() {
        // 测试修改
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book();
        book.setUserId("1");
        book.setUsername("石昊");
        book.setStatus("上苍");
        bookService.updateBook(book);
    }

    @Test
    public void test2() {
        // 测试删除
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.deleteBook("1");
    }
}

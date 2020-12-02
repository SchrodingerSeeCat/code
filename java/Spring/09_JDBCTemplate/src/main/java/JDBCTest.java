import entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void test3() {
        // 测试查询总数
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.allSum());
    }

    @Test
    public void test4() {
        // 测试返回某一条记录
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.findOne("2"));
    }

    @Test
    public void test5() {
        // 测试返回集合
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.findAll());
    }

    @Test
    public void test6() {
        // 测试返回集合
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"3", "楚风", "成长中"});
        batchArgs.add(new Object[]{"4", "曹雨生", "轮回中"});
        batchArgs.add(new Object[]{"5", "石昊", "失踪"});
        bookService.batchAdd(batchArgs);
    }
}

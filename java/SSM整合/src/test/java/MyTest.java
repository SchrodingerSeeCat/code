import com.valid.pojo.Books;
import com.valid.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookMapper = (BookService)context.getBean("bookServiceImpl");
        List<Books> list = bookMapper.queryAll();
        System.out.println(list);
    }
}

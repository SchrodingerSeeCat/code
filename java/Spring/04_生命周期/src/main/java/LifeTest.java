import bean.Order;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println("4.获取对象：" + order);

        // 销毁对象
        ((ClassPathXmlApplicationContext)context).close();
    }
}

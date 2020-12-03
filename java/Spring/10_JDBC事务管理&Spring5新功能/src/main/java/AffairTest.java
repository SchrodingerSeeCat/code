import config.TxConfig;
import function.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import service.AccountService;

public class AffairTest {
    @Test
    public void test() {
        // 测试注解配置事务的方式
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }

    @Test
    public void test1() {
        // 测试xml配置方式
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }

    @Test
    public void test2() {
        // 测试完全注解开发
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }

    @Test
    public void test3() {
        // 1. 创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();

        // 2. 调用context的对象方法进行注册
        context.refresh();
        context.registerBean("user1", User.class, () -> new User());

        // 3.获取在Spring注册的对象
        User user = (User) context.getBean("user1");
        System.out.println(user);
    }
}

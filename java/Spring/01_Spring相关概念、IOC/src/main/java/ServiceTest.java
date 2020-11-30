import bean.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class ServiceTest {
    @Test
    public void test() {
        // 加载Spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 获取配置文件创建的对象
        User user = context.getBean("user", User.class);
        user.show();
    }

    @Test
    public void test1() {
        // 测试外部bean
        ApplicationContext context = new ClassPathXmlApplicationContext("service/bean.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.show();
    }

    @Test
    public void test2() {
        // 测试内部bean
        ApplicationContext context = new ClassPathXmlApplicationContext("bean/bean.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    @Test
    public void test3() {
        // 测试级联
        ApplicationContext context = new ClassPathXmlApplicationContext("bean/bean1.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    @Test
    public void test4() {
        // 测试级联
        ApplicationContext context = new ClassPathXmlApplicationContext("bean/bean2.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}

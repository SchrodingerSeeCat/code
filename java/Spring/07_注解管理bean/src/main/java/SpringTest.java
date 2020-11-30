import config.Config;
import instance.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;

public class SpringTest {
    @Test
    public void test1() {
        // 测试注解
        ApplicationContext context = new ClassPathXmlApplicationContext("instance/bean.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.show();
    }

    @Test
    public void test2() {
        // 测试@Autowire
        ApplicationContext context = new ClassPathXmlApplicationContext("instance/bean.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.show();
    }

    @Test
    public void test3() {
        // 测试@value
        ApplicationContext context = new ClassPathXmlApplicationContext("instance/bean.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
    }

    @Test
    public void test4() {
        // 测试配置类
        // 加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
    }
}

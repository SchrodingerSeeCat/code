package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class) // 指定JUnit的版本
@ContextConfiguration("classpath:bean.xml") // 加载配置文件
public class JunitTest4 {
    @Autowired
    private AccountService accountService;

    @Test
    public void test() {
        accountService.accountMoney();
    }
}

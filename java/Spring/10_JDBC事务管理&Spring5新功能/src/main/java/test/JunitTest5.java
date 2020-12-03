package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import service.AccountService;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JunitTest5 {

    @Autowired
    private AccountService accountService;

    @Test
    public void test() {
        accountService.accountMoney();
    }
}

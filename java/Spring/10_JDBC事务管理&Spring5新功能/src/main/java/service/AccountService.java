package service;

import dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountService  {

    @Autowired
    @Qualifier(value = "accountDaoImpl")
    private AccountDao accountDao;

    // 转账的操作
    public void accountMoney() {
            // Lucy-100
            accountDao.payment("Lucy", -100);

            // 模拟异常
//            int i = 1 / 0;

            // Alice+100
            accountDao.payment("Alice", +100);
    }
}

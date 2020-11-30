package instance;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.EvaluationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

// 在注解里面value属性值可以省略不写
// 默认值是类名称，首字母小写
@Service
public class UserService {
    // Autowired根据类型自动装入
    @Autowired
    private UserDao userDao;

    // Qualifier按照名称注入
//    @Autowired
//    @Qualifier(value = "userDaoImpl")
//    private UserDao userDao;

    // Resource 根据类型进行注入
//    @Resource
//    private UserDao userDao;

    // Resource 根据名称进行注入
//    @Resource(name = "userDaoImpl")
//    private UserDao userDao;

    // value注入普通类型
    @Value(value = "10")
    private int a;

    public void show() {
        System.out.println("service show.....");
        userDao.show();
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                ", a=" + a +
                '}';
    }
}

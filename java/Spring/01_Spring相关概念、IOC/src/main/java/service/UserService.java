package service;

import dao.UserDao;

public class UserService {
    // 创建UserDao类型的属性，生成set方法
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void show() {
        System.out.println("service.....");
        userDao.update();
    }
}

package service.impl;

import dao.UserDao;
import service.UserService;

/**
 * @Auther: yxl15
 * @Date: 2021/3/5 14:50
 * @Description:
 *
 *      测试 Spring-DI
 *
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 公有的setter方法（用于核心容器来调用该方法以实现依赖注入）
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void find() {
        userDao.find();
        System.out.println("我是UserService，如上是我调用的dao中的方法");
    }
}

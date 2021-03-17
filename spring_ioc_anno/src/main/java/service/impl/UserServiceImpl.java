package service.impl;

import dao.UserDao;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;

/**
 * @Auther: yxl15
 * @Date: 2021/3/5 14:50
 * @Description:
 *
 *      测试 Spring-DI
 *
 */


@Service("userService")  // 将业务层的类标识为Spring中的Bean，相当于xml中的bean标签<bean id='' class=''>
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao") // Spring将name属性解析为Bean实例的名称（所以与UserDao中的@Repository()中的值对应），相当于一下子完成了<property name='' ref=''>中name和ref两个属性
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

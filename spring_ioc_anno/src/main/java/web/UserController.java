package web;

import org.springframework.stereotype.Controller;
import service.UserService;

import javax.annotation.Resource;

/**
 * @Auther: yxl15
 * @Date: 2021/3/5 15:16
 * @Description:
 *
 *      基于Annotation的Bean的装配实现Spring-ioc
 *
 */
@Controller("userController") // 将控制层中的类标识为Spring中的Bean，相当于xml中的bean标签<bean id='' class=''>
public class UserController {

    @Resource(name = "userService")
    private UserService userService; // Spring将name属性解析为Bean实例的名称（所以与UserService类的@Service()中的值对应），相当于一下子完成了<property name='' ref=''>中name和ref两个属性

    public void find() {
        userService.find();
        System.out.println("我是UserController，如上是我调用的service中的方法");
    }
}

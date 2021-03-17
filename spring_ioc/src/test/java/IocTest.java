import dao.UserDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * @Auther: yxl15
 * @Date: 2021/3/5 14:41
 * @Description:
 *
 *      测试 Spring-ioc 和 DI
 *
 */
public class IocTest {

    @Test
    public void daoTest() {
        // 通过类路径的方式来实例化Spring的核心容器————applicationContext
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取容器中的Bean
        UserDao dao = (UserDao) app.getBean("userDao");
        // 调用对象中的方法
        dao.find();
    }

    @Test
    public void ServiceTest() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService) app.getBean("userService");
        service.find();
    }
}

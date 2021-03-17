import web.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: yxl15
 * @Date: 2021/3/5 15:41
 * @Description:
 *
 *      测试  基于Annotation装配Bean
 *
 */
public class AnnoTest {

    @Test
    public void findTestByAnno() {
        // 通过类路径的方式来实例化Spring的核心容器————applicationContext
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("beanAnnotation.xml");
        // 获取容器中的Bean
        UserController controller = (UserController) app.getBean("userController");
        controller.find();

    }
}

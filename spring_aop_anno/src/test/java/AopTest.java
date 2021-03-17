import dao.Target;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: yxl15
 * @Date: 2021/3/8 09:48
 * @Description:
 *
 *      利用AspectJ实现aop的测试类
 *
 */
public class AopTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("aopAnnotation.xml");
        Target target = (Target) app.getBean("targetImpl");
        target.save();
    }

}

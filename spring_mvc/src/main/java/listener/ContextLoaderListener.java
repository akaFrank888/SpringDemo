package listener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Auther: yxl15
 * @Date: 2021/3/10 11:07
 * @Description:
 */
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 每次启动web程序就创建应用上下文对象
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 将app对象存入servletContext域中
        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("app", app);

        System.out.println("监听器作用完毕...");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

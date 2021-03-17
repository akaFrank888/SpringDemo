package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yxl15
 * @Auther: yxl15
 * @Date: 2021/3/16 14:50
 * @Description:
 */
public class MyInterceptor implements HandlerInterceptor {


    /**
            在目标方法执行之前执行（该方法可以取到request和response中的信息）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler...");
        // 若是返回false，则不会继续向下执行
        return true;
    }

    /**
     *      在目标方法执行之后，视图返回之前执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    /**
     *      在目标方法执行完毕后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }


}

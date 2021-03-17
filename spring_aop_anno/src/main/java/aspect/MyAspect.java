package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Auther: yxl15
 * @Date: 2021/3/8 09:23
 * @Description: 切面类
 */
@Component   // Spring识别组件的注解。如果不传参，默认是类名的首字母小写作为bean的名称
@Aspect
public class MyAspect {

    /**
     * 切入点表达式的格式：
     * (返回类型 包名.类名.方法名(参数列表))         --->         表示将会切入到哪些方法中
     */

    // 定义切入点表达式
    @Pointcut("execution(* dao.*.*(..))")
    // 使用一个返回值为void，方法体为空的方法命名切入点
    private void pointCut() {}

    // 前置通知
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.print("前置通知：模拟执行权限检查...");
        System.out.print("目标类：" + joinPoint.getTarget());
        System.out.println("，被织入通知的目标方法为：" + joinPoint.getSignature().getName());
    }

    // 后置通知
    @AfterReturning("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.print("后置通知：模拟记录日志...");
        System.out.println("，被织入通知的目标方法为：" + joinPoint.getSignature().getName());
    }

    // 环绕通知（返回obj！！）
    @Around("pointCut()")
    public Object round(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 环绕开始
        System.out.println("环绕开始：执行目标方法之前，模拟开启事务...");
        // 执行目标方法
        Object obj = proceedingJoinPoint.proceed();
        // 环绕结束
        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务...");

        return obj;
    }

    // 异常通知（还有一个关于异常的参数！！）
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常通知：出错了 " + e.getMessage());
    }

    // 最终通知
    @After("pointCut()")
    public void after() {
        System.out.println("最终通知：模拟方法结束后的释放资源...");
    }
}

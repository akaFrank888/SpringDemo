package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * @author yxl15
 * @Auther: yxl15
 * @Date: 2021/3/16 14:42
 * @Description:
 *
 *     将被拦截的方法（测试拦截器）
 *
 */
@Controller
public class InterceptorController {

    @RequestMapping("/target")
    public ModelAndView show() {
        System.out.println("被拦截的资源执行");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "yxl");
        modelAndView.setViewName("success");
        return modelAndView;

    }
}

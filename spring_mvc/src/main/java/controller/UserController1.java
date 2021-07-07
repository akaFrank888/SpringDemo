package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yxl15
 * @Date: 2021/3/10 16:49
 * @Description:
 *
 *      数据响应 ———————— 利用注解实现Spring-MVC的控制层
 *
 */

@Controller
@RequestMapping("/user1")
public class UserController1 {

    /**
            页面跳转的方式一：直接返回字符串
     */
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller is saving..");
        /*
            return "forward:success";       ——————>    转发（默认）
            return "redirect:success";     ——————>    重定向
         */
        return "success";
    }


    /**
            页面跳转的方式二：返回ModelAndView对象
     */
    @RequestMapping("/quick2")
    public ModelAndView save2() {
        ModelAndView modelAndView = new ModelAndView();
        /*
             Model：用于封装数据
             View：用于展示数据
         */
        // 设置模型
        modelAndView.addObject("username", "zhangsan");
        // 设置视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    // 以下都是ModelAndView的其他形式
    @RequestMapping("quick21")
    public ModelAndView save21(ModelAndView modelAndView) {
        modelAndView.addObject("username", "zhangsan");
        modelAndView.setViewName("success");

        return modelAndView;
    }
    // 把两者拆开
    @RequestMapping("quick22")
    public String save22(Model model){
        model.addAttribute("username", "zhangsan");
        return "success";
    }


    // ===================================================================================================


    /**
        回写数据的方式一：直接返回字符串            （只要不进行页面跳转，就加上 @ResponseBody注解 ）
     */
    @RequestMapping("/quick3")
    @ResponseBody
    public void save3(HttpServletResponse response) throws IOException {

        response.getWriter().write("return a String");
    }

    @RequestMapping("/quick4")
    @ResponseBody      //通过注解告知SpringMVC框架————该方法是在http响应体中返回字符串，而不是跳转
    public String save4() {
        return "return a String, too";
    }

    // json字符串
    @RequestMapping("/quick5")
    @ResponseBody
    public String save5() {
        return "{\"username\":\"zhangsan\",\"age\":\"13\"}";
    }

    // json字符串
    @RequestMapping("/quick6")
    @ResponseBody
    public String save6() throws JsonProcessingException {
        User user = new User();
        user.setName("zhangsan");
        user.setAge(13);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(user);

    }

    /**
        因为在spring-mvc.xml中配置了 mvc注解驱动 ，所以可以在controller层直接返回对象，springMVC会将其转换成String类型

        对象 和 集合 是一样的道理
     */
    @RequestMapping("/quick7")
    @ResponseBody
    public User save7() {

        User user = new User();
        user.setName("zhangsan");
        user.setAge(13);

        return user;

    }


}

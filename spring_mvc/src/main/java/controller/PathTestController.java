package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yxl15
 * @date 2021/3/20 16:16
 * @description 测试request和servlet的各种路径
 */

@Controller
@RequestMapping("/pathTest")
public class PathTestController {

    @RequestMapping("/test")
    @ResponseBody
    public void Test(HttpServletRequest request) {

        //      /pathTest/test
        System.out.println("request.getRequestURI():" + request.getRequestURI());
        //      http://localhost:8080/pathTest/test
        System.out.println("request.getRequestURL():" + request.getRequestURL());
        //      (空)
        System.out.println("request.getContextPath():" + request.getContextPath());
        //      /pathTest/test
        System.out.println("request.getServletPath():" + request.getServletPath());
        //      D:\Java\project\SpringDemo\spring_mvc\src\
        System.out.println("request.getServletContext().getRealPath(\"/\"):"+request.getServletContext().getRealPath("/"));

    }
}

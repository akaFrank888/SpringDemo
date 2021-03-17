package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.MessageUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: yxl15
 * @Date: 2021/3/12 15:21
 * @Description:
 *
 *      获得请求参数 ———————— 利用注解实现Spring-MVC的控制层
 *
 */

@Controller
@RequestMapping("/user2")
public class UserController2 {

    /**
     *      获得请求参数————基本数据类型的 自动匹配映射
     *
     *      url： localhost:8080/user2/quick1?username=zhangsan&age=14
     */
    @RequestMapping("/quick1")
    @ResponseBody
    public void save1(String username, int age) {
        System.out.println(username);
        // 虽然客户端传来的参数都是字符串类型，但因为Spring-MVC是框架，提供了一些常用的类型转换器，所以不用再转age为String
        System.out.println(age);
    }

    /**
     *      获得请求参数————POJO类型的 自动匹配映射（SpringMVC会自动将参数匹配映射到user中，前提是pojo中的属性与参数名称相同）
     *
     *      url： localhost:8080/user2/quick2?username=zhangsan&age=14
     */
    @RequestMapping("/quick2")
    @ResponseBody
    public void save2(User user) {
        System.out.println(user);
    }

    /**
     *      获得请求参数————数组类型的 自动匹配映射（SpringMVC会参数匹配映射，前提是两者的名称相同）
     *
     *      url： localhost:8080/user2/quick3?strs=111&strs=222&strs=333
     */
    @RequestMapping("/quick3")
    @ResponseBody
    public void save3(String[] strs) {
        System.out.println(Arrays.toString(strs));
    }

    /**
     *      获得请求参数————集合且为json类型的 自动匹配映射 （测试的话需要前端提交表单）
     *      / @RequestBody用于将请求体中的数据绑定到方法的形参上
     */
    @RequestMapping("/quick4")
    @ResponseBody
    public void save4(@RequestBody List<User> list) {
        System.out.println(list);
    }

    /**
     *      获得请求参数————Restful风格（GET、POST、DELETE、PUT体现在 @RequestMapping中）
     *
     *      Restful规范与风格：1）请求参数成为路径的一部分，而不是参数形式  2）url中不存在动词形式的路径（如items/1，而不是queryItems/1）
     *
     *      {username}是占位符、@PathVariable注解用于占位符的匹配工作、required：是否必须携带此请求头
     */
    @RequestMapping(value = "/quick5/{username}",method = RequestMethod.GET)
    @ResponseBody
    public void save5(@PathVariable(value = "username",required = true) String username) {
        System.out.println(username);
    }

    @RequestMapping(value = "/oneUser/{name}",method = RequestMethod.GET)
    @ResponseBody
    public User query(@PathVariable(value = "name",required = true) String name) {
        System.out.println("查找name为"+name+"的用户");
        User user = new User();

        if ("yxl".equals(name)) {
            user.setName("yxl");
            user.setAge(20);
        }

        // 返回json格式的数据
        return user;
    }



    /**
     *       获得请求参数————请求头信息
     */
    @RequestMapping("/quick6")
    @ResponseBody
    public void save6(@RequestHeader(value = "User-Agent", required = false) String user_agent) {
        System.out.println(user_agent);
    }
    /**
     *       获得请求参数————专门获得请求头信息中的 cookie（此value的值不是header的name，而是cookie的name）
     */
    @RequestMapping("/quick7")
    @ResponseBody
    public void save7(@CookieValue(value = "JSESSIONID", required = false) String jsessionid) {
        System.out.println(jsessionid);
    }


    /**
     * 获得请求参数————单文件与多文件上传
     */
    @RequestMapping("/quick8")
    @ResponseBody
    public void upload(String username, MultipartFile uploadFile, MultipartFile uploadFile2) throws IOException {
        System.out.println(username);

        // 获得上传的文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        // 将文件移动到目标路径
        uploadFile.transferTo(new File("D:\\Java\\project\\SpringDemo\\spring_mvc\\src\\main\\java\\temp\\" + originalFilename));

        String originalFilename2 = uploadFile2.getOriginalFilename();
        uploadFile2.transferTo(new File("D:\\Java\\project\\SpringDemo\\spring_mvc\\src\\main\\java\\temp\\" + originalFilename2));

        // 还可以用数组的形式存储多文件

    }
}

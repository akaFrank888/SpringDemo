package dao.impl;

import dao.Target;
import org.springframework.stereotype.Component;

/**
 * @Auther: yxl15
 * @Date: 2021/3/8 09:21
 * @Description:
 *
 *      实现aop的目标类
 *
 */

@Component  // Spring识别组件的注解。如果不传参，默认是类名的首字母小写作为bean的名称
public class TargetImpl implements Target {

    public void save() {
        System.out.println("保存成功！");
    }

}

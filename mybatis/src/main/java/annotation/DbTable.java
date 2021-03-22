package annotation;

import java.lang.annotation.*;

/**
 * @author yxl15
 * @date 2021/3/21 15:36
 * @description
 *
 *      自定义注解   ————    标记表的名称
 *
 *      （对于元注解的详情，请看oneNote笔记）
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DbTable {
    String tableName();
}

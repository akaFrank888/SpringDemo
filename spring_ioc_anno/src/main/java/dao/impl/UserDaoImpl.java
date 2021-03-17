package dao.impl;

import dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Auther: yxl15
 * @Date: 2021/3/5 14:31
 * @Description:
 */
@Repository("userDao") // 将持久层中的类标识为Spring中的Bean，相当于xml中的bean标签<bean id='' class=''>
public class UserDaoImpl implements UserDao {

    public void find() {
        System.out.println("userDao的find()方法测试");
    }

}

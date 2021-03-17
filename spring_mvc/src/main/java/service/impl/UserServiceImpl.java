package service.impl;

import dao.UserDao;
import service.UserService;

/**
 * @Auther: yxl15
 * @Date: 2021/3/9 19:03
 * @Description:
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void save() {
        userDao.save();
    }

}

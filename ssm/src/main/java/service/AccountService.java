package service;

import domain.Account;

import java.util.List;

/**
 * @Auther: yxl15
 * @Date: 2021/2/12 19:40
 * @Description:
 */
public interface AccountService {

    // 保存
    void save(Account account);

    // 查询
    List<Account> findAll();

}

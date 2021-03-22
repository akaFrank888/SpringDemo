package mapper;

import domain.User;

import java.util.List;

/**
 * @author yxl15
 * @date 2021/3/21 15:53
 * @description
 */
public interface UserMapper {

    /**
     * @param id
     * @return user
     * @description 查
     * @date 2021/3/21 15:56
     */
    User findById(int id);

    /**
     * @param user
     * @return void
     * @description 增
     * @date 2021/3/22 8:19
     */
    void save(User user);

    /**
     * @param id
     * @return void
     * @description 删
     * @date 2021/3/22 8:26
     */
    void delete(int id);

    /**
     * @param user
     * @return void
     * @description 改
     * @date 2021/3/22 8:28
     */
    void update(User user);

    /**
     * @param user
     * @return user
     * @description 动态SQL————if
     * @date 2021/3/22 9:08
     */
    User findByUser(User user);

    /**
     * @param list
     * @return user
     * @description 动态SQL————foreach
     * @date 2021/3/22 9:24
     */
    User findByIds(List<Integer> list);

}

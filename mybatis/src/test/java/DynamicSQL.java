import domain.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yxl15
 * @date 2021/3/22 09:06
 * @description
 *
 *      动态sql   ————   if，foreach
 *
 */
public class DynamicSQL {

    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        // 加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获得session（自动提交事务）
        SqlSession session = factory.openSession(true);
        // 获得mapper
        this.mapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void findByUser() {
        User user = new User();
        user.setUsername("liliu");

        User resUser = mapper.findByUser(user);
        System.out.println(resUser);
    }

    @Test
    public void findByIds() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(8);

        User user = mapper.findByIds(list);
        System.out.println(user);
    }




    public UserMapper getMapper() {
        return mapper;
    }
}

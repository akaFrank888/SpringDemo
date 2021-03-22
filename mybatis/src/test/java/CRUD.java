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

/**
 * @author yxl15
 * @date 2021/3/21 16:59
 * @description
 *
 *      利用Mybatis实现简单的CRUD
 *
 */
public class CRUD {

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

    //  “查”
    @Test
    public void findById() {
        User user = mapper.findById(2);
        System.out.println(user);
    }

    // “增”
    @Test
    public void save() {
        User user = new User( "ljw", 21);
        mapper.save(user);
        System.out.println("保存成功！");
    }

    // “删”
    @Test
    public void delete() {
        mapper.delete(4);
        System.out.println("删除成功！");
    }

    // “改”
    @Test
    public void update() {
        User user = new User(6, "liliu", 35);
        mapper.update(user);
        System.out.println("修改成功！");
    }







    public UserMapper getMapper() {
        return mapper;
    }
}

import com.valid.dao.UserMapper;
import com.valid.pojo.User;
import com.valid.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {
    @Test
    public void test() {
        // 测试查询
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUsers();
        System.out.println(users);

        sqlSession.close();
    }

    @Test
    public void test1() {
        // 测试通过ID查询
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test2() {
        // 测试插入
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.InsertUser(new User(6, "无始", "793453"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() {
        // 测试修改
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.updateUser(new User(4, "无终仙王", "99999"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() {
        // 测试删除
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteUser(6);

        sqlSession.commit();
        sqlSession.close();
    }
}

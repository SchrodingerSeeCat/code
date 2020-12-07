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
    private static Logger logger =Logger.getLogger(UserDaoTest.class);

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);

        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void test1() {
        // 测试日志级别
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
    }

    @Test
    public void test2() {
        // 测试分页查询
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("start", 2);
        map.put("sum", 2);
        List<User> list = userMapper.getUserByLimit(map);
        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void test3() {
        // RowBounds 不推荐使用
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RowBounds rowBounds = new RowBounds(1, 2);
        List<User> list = sqlSession.selectList("com.valid.dao.UserMapper.getUserByRowBounds", null, rowBounds);

        System.out.println(list);
        sqlSession.close();
    }
}

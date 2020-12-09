import com.valid.dao.UserMapper;
import com.valid.pojo.User;
import com.valid.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CacheTest {
    @Test
    public void test() {
        // 测试一级缓存
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByID(1);
        System.out.println(user);
        System.out.println("==================");

        // 手动清除缓存
        sqlSession.clearCache();

        User user2 = userMapper.getUserByID(1);
        System.out.println(user2);
        sqlSession.close();
    }

    @Test
    public void test1() {
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        User user1 = userMapper1.getUserByID(1);
        sqlSession1.close();

        System.out.println("========================================");
        User user2 = userMapper2.getUserByID(1);

        System.out.println(user1);
        System.out.println(user2);


        sqlSession2.close();
    }
}

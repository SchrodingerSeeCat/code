import com.valid.dao.BlogMapper;
import com.valid.pojo.Blog;
import com.valid.utils.IDutils;
import com.valid.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.*;

public class DaoTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1() {
        // IF
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("title", "Spring");
        map.put("author", "狂神说");
        List<Blog> list = blogMapper.queryBlogIF(map);

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void test2() {
        // choose
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("author", "狂神说");
        List<Blog> list = blogMapper.queryBlogChoose(map);

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void test3() {
        // choose
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", "9756d78dded44ffa84f9c1f100b98c2e");
        map.put("title", "Golang");
        int i = blogMapper.updateBlog(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() {
        // foreach
        SqlSession sqlSession = MybatisUtils.getSqlSession();


        Map<String, Object> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        map.put("ids", arrayList);

        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> list = blogMapper.queryBlogForeach(map);
        System.out.println(list);

        sqlSession.close();
    }
}

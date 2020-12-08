import com.valid.dao.StudentMapper;
import com.valid.pojo.Student;
import com.valid.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = studentMapper.getStudent();
        for(Student student : list) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}

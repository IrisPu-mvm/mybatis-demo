import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @ClassName MyBatisTest
 * @Description TODO
 * @Author pyt
 * @Date 2019/11/1 14:34
 * @Version
 */
public class MyBatisTest {
    //https://blog.csdn.net/hellozpc/article/details/80878563#13_26
    public static void main(String[] args) throws Exception{
        //指定全局配置文件
        String resource = "mybatis-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            //操作CRUD,第一个参数：指定statement，规则：命名空间+“。”+statementId
            //第二个参数：指定传入sql参数，这里是用户id
            User user = sqlSession.selectOne("MyMapper.selectUser",1);
            System.out.println(user);
        }finally {
            sqlSession.close();
        }

    }
}

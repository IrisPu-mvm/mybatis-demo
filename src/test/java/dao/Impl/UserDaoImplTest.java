package dao.Impl;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoImplTest {
    public UserDao userDao;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        //指定全局配置文件
        String resource = "mybatis-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        this.sqlSession = sqlSessionFactory.openSession();
        this.userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void queryUerById() {
        System.out.println(this.userDao.queryUerById("1"));
    }

    @Test
    public void queryUserAll() {
        List<User> users = this.userDao.queryUserAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void insert() {
        User user = new User();
        user.setId("3");
        user.setAge(16);
        user.setBirthday(new Date("1990/09/02"));
        user.setName("大鹏");
        user.setPassword("123456");
        user.setUserName("evan");
        user.setSex((byte)1);
        this.userDao.insert(user);
        this.sqlSession.commit();
    }

    @Test
    public void update() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静鹏");
        user.setPassword("654321");
        user.setSex((byte)1);
        user.setUserName("evanjin");
        user.setId("1");
        this.userDao.update(user);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUser() {
        this.userDao.deleteUser("1");
        this.sqlSession.commit();
    }
}
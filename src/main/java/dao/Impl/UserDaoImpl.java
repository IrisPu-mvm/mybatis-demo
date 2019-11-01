package dao.Impl;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author pyt
 * @Date 2019/11/1 14:52
 * @Version
 */
public class UserDaoImpl implements UserDao {
    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User queryUerById(String id) {
        return this.sqlSession.selectOne("UserDao.queryUerById",id);
    }

    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    public void insert(User user) {
        this.sqlSession.insert("UserDao.insertUser",user);
    }

    public void update(User user) {
        this.sqlSession.update("UserDao.updateUser",user);
    }

    public void deleteUser(String id) {
        this.sqlSession.delete("UserDao.deleteUser",id);
    }
}

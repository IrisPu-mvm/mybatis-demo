package dao;

import entity.User;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author pyt
 * @Date 2019/11/1 14:47
 * @Version
 */
public interface UserDao {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public User queryUerById(String id);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     * @param user
     */
    public void insert(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void update(User user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUser(String id);
}

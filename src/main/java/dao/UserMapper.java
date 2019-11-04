package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> queryUserByTableName(@Param("tableName") String tableName);
}

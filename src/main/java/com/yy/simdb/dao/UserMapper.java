package com.yy.simdb.dao;

import com.yy.simdb.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User login(@Param("username") String username, @Param("password") String password);

    List<User> getAllUserList(UserSearch search);

    int getUserByUsername(String username);

    void updateUser(User user);

    void deleteUser(int id);

    List<UserMini> getUserList();

    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByUserId(int id);
}
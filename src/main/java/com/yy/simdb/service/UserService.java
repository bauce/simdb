package com.yy.simdb.service;

import com.yy.simdb.entity.Menu;
import com.yy.simdb.entity.User;
import com.yy.simdb.entity.UserMini;
import com.yy.simdb.entity.UserSearch;
import com.yy.simdb.util.ResultUtil;

import java.util.List;

public interface UserService {
    User login(String username,String password);

    List<Menu> getMenus(User user);

    ResultUtil getAllUerList(Integer page, Integer limit, UserSearch search);

    User getUserById(int id);

    int getUserByUsername(String name);

    int insertUer(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    List<UserMini> getUserList();

}

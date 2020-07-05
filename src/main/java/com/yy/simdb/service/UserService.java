package com.yy.simdb.service;

import com.yy.simdb.entity.Menu;
import com.yy.simdb.entity.User;

import java.util.List;

public interface UserService {
    public User login(String username,String password);

    public List<Menu> getMenus(User user);
}

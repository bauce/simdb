package com.yy.simdb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yy.simdb.dao.MenuMapper;
import com.yy.simdb.dao.RoleMapper;
import com.yy.simdb.dao.RoleMenuMapper;
import com.yy.simdb.dao.UserMapper;
import com.yy.simdb.entity.*;
import com.yy.simdb.service.UserService;
import com.yy.simdb.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public User login(String username, String password) {
        System.out.println(userMapper);
        return userMapper.login(username, password);
    }

    @Override
    public List<Menu> getMenus(User user) {
        List<Menu> menuList = new ArrayList<>();
        long roleId = user.getRoleId();
        List<RoleMenu> roleMenus = roleMenuMapper.getRoleMenuByRoleId(roleId);

        if(roleMenus != null && roleMenus.size() >0 ){

            List<Menu> noChildrenMenus = new ArrayList<Menu>();
            for (int i = 0; i < roleMenus.size(); i++) {
                Menu menu = menuMapper.getMenuById(roleMenus.get(i).getMenuId());
                noChildrenMenus.add(menu);
            }

            for (int i = 0; i < noChildrenMenus.size(); i++) {
                if (noChildrenMenus.get(i).getParentId() == 0) {
                    Menu menu = new Menu();
                    menu = noChildrenMenus.get(i);
                    List<Menu> menus = new ArrayList<Menu>();
                    for (int j = 0; j < noChildrenMenus.size(); j++) {
                        if (noChildrenMenus.get(i).getId() == noChildrenMenus.get(j).getParentId()) {
                            Menu menu2 = new Menu();
                            menu2 = noChildrenMenus.get(j);
                            menus.add(menu2);
                        }
                    }
                    menus = menus.stream().sorted(Comparator.comparing(Menu::getSort).reversed()).collect(Collectors.toList());
                    menu.setChildren(menus);
                    menuList.add(menu);

                }
            }
        }
        menuList = menuList.stream().sorted(Comparator.comparing(Menu::getSort).reversed()).collect(Collectors.toList());
        return menuList;
    }

    @Override
    public ResultUtil getAllUerList(Integer page, Integer limit, UserSearch search) {
        PageHelper.startPage(page,limit);
        List<User> users = userMapper.getAllUserList(search);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int getUserByUsername(String name) {
        return userMapper.getUserByUsername(name);
    }

    @Override
    public int insertUer(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<UserMini> getUserList() {
        return userMapper.getUserList();
    }


}

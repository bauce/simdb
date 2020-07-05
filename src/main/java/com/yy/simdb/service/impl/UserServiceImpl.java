package com.yy.simdb.service.impl;

import com.yy.simdb.dao.MenuMapper;
import com.yy.simdb.dao.RoleMapper;
import com.yy.simdb.dao.RoleMenuMapper;
import com.yy.simdb.dao.UserMapper;
import com.yy.simdb.entity.Menu;
import com.yy.simdb.entity.RoleMenu;
import com.yy.simdb.entity.User;
import com.yy.simdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


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
                    menu.setChildren(menus);
                    menuList.add(menu);

                }
            }
        }
        return menuList;
    }
}

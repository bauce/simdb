package com.yy.simdb.controller;

import com.yy.simdb.dao.UserMapper;
import com.yy.simdb.entity.Menu;
import com.yy.simdb.entity.User;
import com.yy.simdb.service.UserService;
import com.yy.simdb.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil login(String username , String password , HttpServletRequest request,HttpSession session){
        System.out.println(username+":"+password);
        User user = userService.login(username,password);
        if (null != user){
            System.err.println(user.toString());
            session.setAttribute("user", user);
            return ResultUtil.ok(user.getId());
        }
        else {
            return ResultUtil.error();
        }
    }
    @RequestMapping("/index")
    public  String index(HttpSession session) {
        return "redirect:/jsp/index.jsp";
    }

    @RequestMapping("/main")
    public String getMain() {
        return "jsp/main";
    }

    @RequestMapping("/getMenus")
    @ResponseBody
    public List<Menu> getMenus(HttpSession session){
        User user = (User)session.getAttribute("user");
        User user2 = (User)userMapper.selectByPrimaryKey(user.getId());
        List<Menu> menus = null;
        if(null != user2){
            menus = userService.getMenus(user2);
        }
        return  menus;
    }


}

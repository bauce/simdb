package com.yy.simdb.controller;

import com.yy.simdb.dao.UserMapper;
import com.yy.simdb.entity.Menu;
import com.yy.simdb.entity.User;
import com.yy.simdb.entity.UserMini;
import com.yy.simdb.entity.UserSearch;
import com.yy.simdb.service.UserService;
import com.yy.simdb.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("index")
    public  String index(HttpSession session) {
        return "redirect:/jsp/index.jsp";
    }

    @RequestMapping("main")
    public String getMain() {
        return "jsp/main";
    }


    @RequestMapping("addUser")
    public String addUser() {
        return "jsp/user/addUser";
    }

    @RequestMapping("modifyUser")
    public String modifyUser(){ return "jsp/user/modifyUser"; }

    @RequestMapping("changePassword")
    public String changePassword(){ return "jsp/user/changePassword"; }


    @RequestMapping("getMenus")
    @ResponseBody
    public List<Menu> getMenus(HttpSession session){
        User user = (User)session.getAttribute("user");
        User user2 = (User)userMapper.selectByPrimaryKey(user.getUserId());
        List<Menu> menus = null;
        if(null != user2){
            menus = userService.getMenus(user2);
        }
        return  menus;
    }


    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil login(String username , String password , HttpServletRequest request,HttpSession session){
        System.out.println(username+":"+password);
        User user = userService.login(username,password);
        if (null != user){
            System.err.println(user.toString());
            session.setAttribute("user", user);
            return ResultUtil.ok(user.getUserId());
        }
        else {
            return ResultUtil.error();
        }
    }

    @RequestMapping("listUser")
    public String userLIst(){
        List<UserMini> userMiniList = userService.getUserList();
        return "jsp/user/listUser";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public ResultUtil getAllUserList(Integer page,Integer limit, UserSearch search){
        return userService.getAllUerList(page,limit,search);
    }

    @RequestMapping("checkUserByUsername/{username}")
    @ResponseBody
    public ResultUtil checkUserByUsername(@PathVariable("username")String username){
        int un = userService.getUserByUsername(username);
        if(un != 0){
            return new ResultUtil(500,"用户名已存在，请重新填写！");
        }
        return new ResultUtil(0);
    }

    @RequestMapping("insertUser")
    @ResponseBody
    public ResultUtil insUser(User user){
        int un = userService.getUserByUsername(user.getUsername());
        if(un != 0){
            return new ResultUtil(500,"用户名已存在");
        }
        try {
            userService.insertUer(user);
            return ResultUtil.ok();
        }catch (Exception e){
            return new ResultUtil(502,"添加失败");
        }
    }

    @RequestMapping("editUser/{id}")
    public String editUser(@PathVariable("id")int id,HttpSession session){
        User user = userService.getUserById(id);
        session.setAttribute("user",user);
        return "jsp/user/editUser";
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public ResultUtil updateUser(User user){
        userService.updateUser(user);
        return ResultUtil.ok();
    }

    @RequestMapping("deleteUserById")
    @ResponseBody
    public ResultUtil deleteUserById(int id){
        userMapper.deleteByPrimaryKey(id);
        return ResultUtil.ok();
    }

    @RequestMapping("getUserList")
    @ResponseBody
    public ResultUtil getUserList(){
        List<UserMini> data = userMapper.getUserList();
        return ResultUtil.ok(data);
    }

}

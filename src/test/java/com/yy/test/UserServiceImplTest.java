package com.yy.test;

import com.yy.simdb.service.UserService;
import com.yy.simdb.service.WorkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-service.xml"})

public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Autowired
    WorkService workService;

    @Test
    public void login() {
        userService.login("办公室","111");
    }

    @Test
    public void testListWork(){
        workService.getAllWorklist(1,10,null);
    }

    @Test
    public void  testUserMini(){
        System.out.println(userService.getUserList());
    }
}
package com.yy.test;

import com.yy.simdb.dao.UserMapper;
import com.yy.simdb.dao.WorkInfoMapper;
import com.yy.simdb.dao.WorkMapper;
import com.yy.simdb.entity.User;
import com.yy.simdb.entity.Work;
import com.yy.simdb.entity.WorkInfo;
import com.yy.simdb.entity.WorkInfoSearch;
import com.yy.simdb.service.InfoService;
import com.yy.simdb.service.UserService;
import com.yy.simdb.service.WorkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-service.xml"})

public class TestFunctions {

    @Autowired
    UserService userService;

    @Autowired
    WorkService workService;

    @Autowired
    WorkMapper workMapper;

    @Autowired
    WorkInfoMapper workInfoMapper;


    @Autowired
    UserMapper userMapper;

    @Autowired
    InfoService infoService;

    @Test
    public void login() {
        userService.login("办公室","111");
    }

    @Test
    public void testListWork(){
        workService.getAllWorkList(1,10,null);
    }

    @Test
    public void  testUserMini(){
        System.out.println(userService.getUserList());
    }

    @Test
    public void testDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Work work = workMapper.selectByPrimaryKey(13);
        System.out.println(formatter.format(work.getDueTime()));
    }

    @Test
    public void testWork(){
        System.out.println(
                workMapper.getWorkById(10)
        );
    }

    @Test
    public void testWork2(){
        System.out.println(
                workMapper.getWorkByUserId(2)
        );
    }

    @Test
    public void testWork3(){
        User user = userMapper.getUserByUserId(2);
        System.out.println(user);
        List<Work> works = user.getWorks();
        System.out.println(works);
    }
    @Test
    public void testWorkInfo(){
       List<Integer> unFinishedWorkIds =  workMapper.getUnfinishWorkIds();
        System.out.println(unFinishedWorkIds);
       int ic = workInfoMapper.insertInfoListByWids(unFinishedWorkIds);
        System.out.println(ic);
    }

    public void testInsertWorkInfo(){
        int ic = workInfoMapper.insetAInfoByWid(15);
        System.out.println(ic);
    }

    @Test
    public void testSelectWorkInfo(){
        List<WorkInfo> infoList = workInfoMapper.getInfoByWorkId(8);
        System.out.println(infoList);
        System.out.println(infoList.get(0).getWork());
    }

    @Test
    public void testSelectWorkInfoByUserId(){
        List<WorkInfo> infoList = workInfoMapper.getInfoByUserId(2);
        for (WorkInfo info:infoList){
            System.out.println(info);
            System.out.println(info.getWork());
        }
    }
    @Test
    public void testInsertInfo(){
        WorkInfo info = new WorkInfo();
        info.setWid(8);
        info.setStatus(0);
        System.out.println(workInfoMapper.insertSelective(info));
    }

    @Test
    public void infoList(){
        WorkInfoSearch infoSearch = new WorkInfoSearch();
        infoSearch.setStatus(Integer.toString(0));
        infoSearch.setUserId(Integer.toString(2));
        List<WorkInfo> infoList= infoService.getInfoList(infoSearch);
        System.out.println(infoList);
    }

    @Test
    public void testWorkWithInfo(){
        WorkInfoSearch infoSearch = new WorkInfoSearch();
        infoSearch.setWorkId(Integer.toString(1));
        List<Work> w = workMapper.getWorkWithLastInfo(infoSearch);
        System.out.println(w);
    }

    @Test
    public void testGetLastInfo(){
        List<WorkInfo> list = workInfoMapper.getLastInfoByWorkId(1);
        System.out.println(list);
    }
}
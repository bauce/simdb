package com.yy.simdb.controller;


import com.yy.simdb.entity.WorkSearch;
import com.yy.simdb.service.WorkService;
import com.yy.simdb.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/work")
public class WorkController {


    @Autowired
    private WorkService workService;

    @RequestMapping("getAllWorkList")
    @ResponseBody
    public ResultUtil getAllWorkList(Integer page, Integer limit, WorkSearch search){
        return workService.getAllWorklist(page,limit,search);
    }

    @RequestMapping("allWorkList")
    public String userList(){
        return "jsp/user/allWorkList";
    }


}

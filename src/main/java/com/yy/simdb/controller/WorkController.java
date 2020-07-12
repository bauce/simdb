package com.yy.simdb.controller;


import com.yy.simdb.entity.Work;
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

    @RequestMapping("listWork")
    public String userList(){
        return "jsp/work/listWork";
    }

    @RequestMapping("addWork")
    public  String addWork(){
        return "jsp/work/addWork";
    }

    @RequestMapping("editWork")
    public  String editWork(){
        return "jsp/work/editWork";
    }

    @RequestMapping("inserWork")
    @ResponseBody
    public ResultUtil inserWork(Work work){
        int cc = workService.queryByContent(work.getContent());
        if(cc != 0){
            return new ResultUtil(500,"工作已存在");
        }
        try{
            return workService.inserWork(work);
        }catch (Exception e){
            return new ResultUtil(502,"添加失败");
        }
    }

    @RequestMapping("deleteWorkById")
    @ResponseBody
    public ResultUtil deleteWork(int id){
        return workService.deleteWorkByid(id);
    }

}

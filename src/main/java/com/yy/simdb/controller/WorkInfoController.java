package com.yy.simdb.controller;

import com.yy.simdb.entity.WorkInfo;
import com.yy.simdb.entity.WorkInfoSearch;
import com.yy.simdb.service.InfoService;
import com.yy.simdb.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/info")
public class WorkInfoController {

    @Autowired
    InfoService infoService;

    @RequestMapping("addInfo")
    public String addInfo(){ return "jsp/info/addInfo";}

    @RequestMapping("viewInfo")
    public String viewInfo(){ return "jsp/info/viewInfo";}

    @RequestMapping("reviewInfo")
    public String reviewInfo(){ return "jsp/info/reviewInfo";}

    @RequestMapping("listInfo")
    public String listInfo(){ return "jsp/info/listInfo"; }

    @RequestMapping("getLastInfoByWorkId")
    @ResponseBody
    public ResultUtil getLastInfoByWorkId(int wid){
        return infoService.getLastInfoByWorkId(wid);
    }

    @RequestMapping("getLastInfoWithWork")
    @ResponseBody
    public ResultUtil getLastInfoWithWork(Integer page, Integer limit, WorkInfoSearch search){
        return infoService.getLastInfoWithWork(page,limit,search);
    }

    @RequestMapping("updateInfo")
    @ResponseBody
    public ResultUtil updateInfo(WorkInfo info){
        return infoService.updateInfo(info);
    }


    @RequestMapping("submitInfo")
    @ResponseBody
    public ResultUtil submitInfo(WorkInfo info){
        return infoService.submitInfo(info);
    }


    @RequestMapping("archInfo")
    @ResponseBody
    public ResultUtil archInfo(){
        return infoService.archInfo();
    }

}

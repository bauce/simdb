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

    @RequestMapping("revInfo")
    public String revInfo(){ return "jsp/info/reviewInfo"; }

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

    @RequestMapping("reviewInfo")
    @ResponseBody
    public ResultUtil reviewInfo(WorkInfo info){
        return infoService.updateInfo(info);
    }


    @RequestMapping("submitInfo")
    @ResponseBody
    public ResultUtil submitInfo(WorkInfo info){
        return infoService.submitInfo(info);
    }



}
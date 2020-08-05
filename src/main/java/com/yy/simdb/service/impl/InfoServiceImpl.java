package com.yy.simdb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yy.simdb.dao.WorkInfoMapper;
import com.yy.simdb.dao.WorkMapper;
import com.yy.simdb.entity.Work;
import com.yy.simdb.entity.WorkInfo;
import com.yy.simdb.entity.WorkInfoSearch;
import com.yy.simdb.service.InfoService;
import com.yy.simdb.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class InfoServiceImpl implements InfoService {

    @Autowired
    WorkInfoMapper infoMapper;

    @Autowired
    WorkMapper workMapper;

    @Override
    public ResultUtil insertInfo(WorkInfo info) {
        ResultUtil resultUtil;
        List<WorkInfo> infoList = infoMapper.getInfoByWorkId(info.getWid());
        if(infoList.size()!=0){
            return new ResultUtil(500,"还有暂未归档的数据，请过段时间再提交");
        }
        else {
            int ic = infoMapper.insertSelective(info);
            System.out.println("insert_count: "+ic);
            if(ic != 0){
                return new ResultUtil(0,"提交成功");
            }
        }
        return new ResultUtil(500,"提交失败");
    }

    @Override
    public ResultUtil updateInfo(WorkInfo info) {
        infoMapper.updateByPrimaryKeySelective(info);
        ResultUtil resultUtil = new ResultUtil(0);
        return resultUtil;
    }

    @Override
    public List<WorkInfo> getInfoList(WorkInfoSearch infoSearch) {
        return infoMapper.getInfoList(infoSearch);
    }

    @Override
    public ResultUtil getLastInfoByWorkId(int wid) {
        ResultUtil resultUtil = new ResultUtil();
        return resultUtil.ok(infoMapper.getLastInfoByWorkId(wid));
    }

    @Override
    public ResultUtil submitInfo(WorkInfo info) {
        if(null == info.getWorkInfoId()||( ( null != info.getWorkInfoId()) && (info.getStatus()==5))){
            Date date = new Date();
            info.setCreateTime(date);
            infoMapper.insertSelective(info);
        }else {
            infoMapper.updateByPrimaryKeySelective(info);
        }
        return  new ResultUtil(0);
    }


    @Override
    public ResultUtil insertInfoListByWids(List<Integer> wids) {
        return null;
    }

    @Override
    public ResultUtil getLastInfoWithWork(Integer page, Integer limit, WorkInfoSearch infoSearch) {
        PageHelper.startPage(page,limit);
        List<WorkInfo> infos = infoMapper.getLastInfoWithWork(infoSearch);

        PageInfo<WorkInfo> pageInfo = new PageInfo<>(infos);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil archInfo() {
        ResultUtil resultUtil;
        WorkInfoSearch infoSearch = new WorkInfoSearch();
        infoSearch.setFinished(Integer.toString(0));
        List<Work> allInfo = workMapper.getWorkWithLastInfo(infoSearch);
        infoSearch.setStatus(Integer.toString(2));
        List<Work> reviewedInfo = workMapper.getWorkWithLastInfo(infoSearch);
        if (allInfo.size()!= reviewedInfo.size()){
            resultUtil = new ResultUtil();
            resultUtil.setCode(500);
            Map<String,Integer> map = new HashMap<>();
            map.put("all",allInfo.size());
            map.put("rev",reviewedInfo.size());
            resultUtil.setData(map);
            return resultUtil;
        }else {
            infoMapper.archInfo();
            infoMapper.updateFinished();
            resultUtil = new ResultUtil();
            return ResultUtil.ok("操作成功");
        }
    }
}

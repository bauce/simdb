package com.yy.simdb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yy.simdb.dao.WorkMapper;
import com.yy.simdb.entity.Work;
import com.yy.simdb.entity.WorkInfoSearch;
import com.yy.simdb.entity.WorkSearch;
import com.yy.simdb.service.WorkService;
import com.yy.simdb.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public  class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkMapper workMapper;

    @Override
    public ResultUtil getAllWorkList(Integer page, Integer limit, WorkSearch workSearch) {
        PageHelper.startPage(page,limit);
        List<Work> works = workMapper.getAllWorkList(workSearch);
        PageInfo<Work> pageInfo = new PageInfo<>(works);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil getWorkWithLastInfo(Integer page, Integer limit, WorkInfoSearch infoSearch) {

        PageHelper.startPage(page,limit);
        List<Work> works =  workMapper.getWorkWithLastInfo(infoSearch);
        PageInfo<Work> pageInfo = new PageInfo<>(works);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil deleteWorkById(int id) {
        int dc = workMapper.deleteByPrimaryKey(id);
        ResultUtil resultUtil = new ResultUtil();
        if (dc != 0){
            resultUtil.setCode(0);
        }else{
            resultUtil.setCode(500);
            resultUtil.setMsg("删除失败");
        }
        return resultUtil;
    }

    @Override
    public ResultUtil insertWork(Work work) {
        work.setCreateTime(new Date());
        work.setFinished((byte) 0);
        System.err.println(work.toString());
        ResultUtil resultUtil = new ResultUtil();
        int ic = workMapper.insertSelective(work);
        if (ic != 0){
            resultUtil.setCode(0);
            return resultUtil;
        }else{
            resultUtil.setCode(500);
            resultUtil.setMsg("添加失败");
            return resultUtil;
        }
    }

    @Override
    public ResultUtil updateWork(Work work) {
        int uc = workMapper.updateByPrimaryKeySelective(work);
        ResultUtil resultUtil = new ResultUtil();
        if (uc != 0){
            resultUtil.setCode(0);
            return resultUtil;
        }else{
            resultUtil.setCode(500);
            resultUtil.setMsg("更新失败");
            return resultUtil;
        }
    }

    @Override
    public int queryByContent(String content) {
        return workMapper.queryByContent(content);
    }
}

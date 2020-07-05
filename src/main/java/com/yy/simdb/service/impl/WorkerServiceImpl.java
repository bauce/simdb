package com.yy.simdb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yy.simdb.dao.WorkMapper;
import com.yy.simdb.entity.Work;
import com.yy.simdb.entity.WorkSearch;
import com.yy.simdb.service.WorkService;
import com.yy.simdb.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkerServiceImpl implements WorkService {

    @Autowired
    private WorkMapper workMapper;

    @Override
    public ResultUtil getAllWorklist(Integer page, Integer limit, WorkSearch workSearch) {
        PageHelper.startPage(page,limit);
        List<Work> works = workMapper.getAllWorkList(workSearch);
        PageInfo<Work> pageInfo = new PageInfo<>(works);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }
}

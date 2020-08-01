package com.yy.simdb.service;

import com.yy.simdb.entity.Work;
import com.yy.simdb.entity.WorkInfoSearch;
import com.yy.simdb.entity.WorkSearch;
import com.yy.simdb.util.ResultUtil;

public interface WorkService {

    ResultUtil getAllWorkList(Integer page , Integer limit, WorkSearch workSearch);

    ResultUtil getWorkWithLastInfo(Integer page, Integer limit, WorkInfoSearch infoSearch);

    ResultUtil deleteWorkById(int id);

    ResultUtil insertWork(Work work);

    ResultUtil updateWork(Work work);

    int queryByContent(String content);

}

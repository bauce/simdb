package com.yy.simdb.service;

import com.yy.simdb.entity.WorkInfo;
import com.yy.simdb.entity.WorkInfoSearch;
import com.yy.simdb.util.ResultUtil;

import java.util.List;

public interface InfoService {

    ResultUtil insertInfo(WorkInfo info);

    ResultUtil updateInfo(WorkInfo info);

    List<WorkInfo> getInfoList(WorkInfoSearch infoSearch);

    ResultUtil getLastInfoByWorkId(int wid);

    ResultUtil submitInfo(WorkInfo info);

    ResultUtil insertInfoListByWids(List<Integer> wids);

    ResultUtil getLastInfoWithWork(Integer page, Integer limit, WorkInfoSearch infoSearch);

    ResultUtil archInfo();

}

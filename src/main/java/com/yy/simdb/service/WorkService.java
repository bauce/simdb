package com.yy.simdb.service;

import com.yy.simdb.entity.WorkSearch;
import com.yy.simdb.util.ResultUtil;

public interface WorkService {

    ResultUtil getAllWorklist(Integer page , Integer limit, WorkSearch workSearch);

}

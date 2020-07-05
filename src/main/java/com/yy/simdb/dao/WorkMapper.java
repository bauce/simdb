package com.yy.simdb.dao;

import com.yy.simdb.entity.Work;
import com.yy.simdb.entity.WorkExample;
import com.yy.simdb.entity.WorkSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExampleWithBLOBs(WorkExample example);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExampleWithBLOBs(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKeyWithBLOBs(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> getAllWorkList(WorkSearch search);

}
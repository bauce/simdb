package com.yy.simdb.dao;

import com.yy.simdb.entity.Work;
import com.yy.simdb.entity.WorkExample;
import com.yy.simdb.entity.WorkWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkWithBLOBs record);

    int insertSelective(WorkWithBLOBs record);

    List<WorkWithBLOBs> selectByExampleWithBLOBs(WorkExample example);

    List<Work> selectByExample(WorkExample example);

    WorkWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkWithBLOBs record, @Param("example") WorkExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkWithBLOBs record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(WorkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WorkWithBLOBs record);

    int updateByPrimaryKey(Work record);
}
package com.yy.simdb.dao;

import com.yy.simdb.entity.WorkInfo;
import com.yy.simdb.entity.WorkInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkInfoMapper {
    long countByExample(WorkInfoExample example);

    int deleteByExample(WorkInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkInfo record);

    int insertSelective(WorkInfo record);

    List<WorkInfo> selectByExampleWithBLOBs(WorkInfoExample example);

    List<WorkInfo> selectByExample(WorkInfoExample example);

    WorkInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkInfo record, @Param("example") WorkInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkInfo record, @Param("example") WorkInfoExample example);

    int updateByExample(@Param("record") WorkInfo record, @Param("example") WorkInfoExample example);

    int updateByPrimaryKeySelective(WorkInfo record);

    int updateByPrimaryKeyWithBLOBs(WorkInfo record);

    int updateByPrimaryKey(WorkInfo record);
}
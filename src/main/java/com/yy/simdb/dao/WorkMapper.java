package com.yy.simdb.dao;

import com.yy.simdb.entity.Work;
import com.yy.simdb.entity.WorkExample;
import com.yy.simdb.entity.WorkInfoSearch;
import com.yy.simdb.entity.WorkSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {

    List<Work> getAllWorkList(WorkSearch search);

    int queryByContent(String content);

    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    List<Integer> getUnfinishWorkIds();

    Work getWorkById(int id);

    List<Work> getWorkByUserId(int id);

    List<Work> getWorkWithLastInfo(WorkInfoSearch infoSearch);

    /******************以下为自动生成的*******************/

    List<Work> selectByExampleWithBLOBs(WorkExample example);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExampleWithBLOBs(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKeyWithBLOBs(Work record);

    int updateByPrimaryKey(Work record);

}
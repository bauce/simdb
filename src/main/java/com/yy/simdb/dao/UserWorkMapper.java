package com.yy.simdb.dao;

import com.yy.simdb.entity.UserWork;
import com.yy.simdb.entity.UserWorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserWorkMapper {
    long countByExample(UserWorkExample example);

    int deleteByExample(UserWorkExample example);

    int insert(UserWork record);

    int insertSelective(UserWork record);

    List<UserWork> selectByExample(UserWorkExample example);

    int updateByExampleSelective(@Param("record") UserWork record, @Param("example") UserWorkExample example);

    int updateByExample(@Param("record") UserWork record, @Param("example") UserWorkExample example);
}
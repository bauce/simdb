package com.yy.simdb.dao;

import com.yy.simdb.entity.RoleMenu;
import com.yy.simdb.entity.RoleMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuMapper {

    List<RoleMenu>  getRoleMenuByRoleId(long roleId);

    long countByExample(RoleMenuExample example);

    int deleteByExample(RoleMenuExample example);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    List<RoleMenu> selectByExample(RoleMenuExample example);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);
}
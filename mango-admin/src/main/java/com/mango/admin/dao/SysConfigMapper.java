package com.mango.admin.dao;

import com.mango.admin.entity.SysConfig;

import java.util.List;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);

    List<SysConfig> findByLable(String lable);
    List<SysConfig> findPage();
}
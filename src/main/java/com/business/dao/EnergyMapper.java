package com.business.dao;

import com.business.pojo.Energy;

import java.util.List;

public interface EnergyMapper {
    int deleteByPrimaryKey(Integer energyId);

    int insert(Energy record);

    int insertSelective(Energy record);

    Energy selectByPrimaryKey(Integer energyId);

    int updateByPrimaryKeySelective(Energy record);

    int updateByPrimaryKey(Energy record);

    List<Energy> selectenergys();
}
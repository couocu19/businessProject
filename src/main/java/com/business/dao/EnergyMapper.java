package com.business.dao;

import com.business.pojo.Energy;

public interface EnergyMapper {
    int deleteByPrimaryKey(Integer energyId);

    int insert(Energy record);

    int insertSelective(Energy record);

    Energy selectByPrimaryKey(Integer energyId);

    Energy selectByName(String name);

    int updateByPrimaryKeySelective(Energy record);

    int updateByPrimaryKey(Energy record);
}
package com.business.dao;

import com.business.pojo.Business;

public interface BusinessMapper {
    int deleteByPrimaryKey(Integer businessId);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(Integer businessId);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
}
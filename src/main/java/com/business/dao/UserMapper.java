package com.business.dao;

import com.business.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectByAccountNumber(String accountNumber);

    User checkUser(@Param("accountNumber") String accountNumber, @Param("password") String password);
}
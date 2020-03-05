package com.business.Service;

import com.business.pojo.Business;
import com.business.pojo.User;

import java.util.Map;

public interface UserService {
    Map<String,Object> login(User user);

    Map<String, Object> regist(User user);

    Map<String, Object> addbusiness(Business business);

    Map<String, Object> selectbusiness(Integer userId);

    Map<String, Object> updatebusiness(Business business);

    Map<String, Object> deletebusiness(Integer businessId, Integer userId);
}

package com.business.Service.ServiceImp;

import com.business.Service.UserService;
import com.business.common.Const;
import com.business.dao.BusinessMapper;
import com.business.dao.UserMapper;
import com.business.pojo.Business;
import com.business.pojo.User;
import com.business.util.MD5Util;
import com.fasterxml.jackson.core.JsonEncoding;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServcieImp implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    BusinessMapper businessMapper;

    @Override //用户登录
    public Map<String, Object> login(User user) {
        Map<String,Object> map =new HashMap<>();
        if (user==null||user.getPassword()==null){ //简单校验参数
            map.put("code",1);
            map.put("error","密码为空");
            return map;
        }
        //System.out.println("test.action");
        String password = MD5Util.MD5EncodeUtf8(user.getPassword(), Const.SALT);//MD5加密
        user.setPassword(password);
        // 数据库校验用户名密码
        User checkuser = userMapper.checkUser(user.getAccountNumber(),user.getPassword());
        if (checkuser==null) { //数据库校验失败
            map.put("code",1);
            map.put("error","账号或密码错误");
            return  map;
        }

        //给前端返回成功信息
        map.put("code",0);
        map.put("msg","ok");
        map.put("result",checkuser.getId());
        return  map;
    }

    @Override  //用户注册
    public Map<String, Object> regist(User user) {
        Map<String,Object> map = new HashMap<>();
        if (user==null||user.getPassword()==null||user.getAccountNumber()==null){ //简单校验参数
            map.put("code",1);
            map.put("error","注册信息不完备");
            return map;
        }
        // 到数据库判断账号是否有重复
        int count = userMapper.selectByAccountNumber(user.getAccountNumber());
        if (count>0) { //数据库中账号有重复
            map.put("code",1);
            map.put("error","此账号已被注册");
            return map;
        }
        //System.out.println("test.action");
        String password = MD5Util.MD5EncodeUtf8(user.getPassword(),Const.SALT);//MD5加密
        user.setPassword(password);
        // 将注册的信息存入数据库
        userMapper.insertSelective(user);
        //注册成功
        //给前端返回成功信息
        map.put("code",0);
        map.put("msg","ok");
        return  map;
    }

    @Override  //用户添加企业
    public Map<String, Object> addbusiness(Business business) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(business.getBusinessName())||StringUtils.isEmpty(business.getLegalPersion())){
            map.put("code",1);
            map.put("error","录入数据不完备");
            return map;
        }
        businessMapper.insertSelective(business);
        //添加成功
        map.put("code",0);
        map.put("msg","ok");
        return map;
    }

    @Override
    public Map<String, Object> selectbusiness(Integer userId) {
        Map<String,Object> map =new HashMap<>();
       List<Business> businessList = businessMapper.selectByUserId(userId);
       map.put("code",0);
       map.put("msg","ok");
       map.put("result",businessList);
        return map;
    }

    @Override
    public Map<String, Object> updatebusiness(Business business) {
        businessMapper.updateByPrimaryKeySelective(business);
        Map<String,Object> map =new HashMap<>();
        map.put("code",0);
        map.put("msg","ok");
        return map;
    }

    @Override
    public Map<String, Object> deletebusiness(Integer businessId, Integer userId) {
        Business business = businessMapper.selectByPrimaryKey(businessId);
        Map<String,Object> map = new HashMap<>();
        if (business.getUserId()!=userId) {
            map.put("code",1);
            map.put("error","用户无权限");
            return  map;
        }
        businessMapper.deleteByPrimaryKey(businessId);
        map.put("code",0);
        map.put("msg","ok");
        return  map;
    }
    public static void main(String[] args) {
        String salt="geelysdafaqj23ou89ZXcj@#$@#$#@KJdjklj;D../dSF.,";//加盐
        System.out.println(MD5Util.MD5EncodeUtf8("admin",salt));
    }
}

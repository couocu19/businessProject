package com.business.Controller;

import com.business.Service.UserService;
import com.business.pojo.Business;
import com.business.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //用户注册接口
    @RequestMapping("/regist.action")
    public Map<String,Object> regist(@RequestBody User user){
      return userService.regist(user);
    }
    //用户登录接口
    @RequestMapping("/login.action")
    public Map<String,Object> login(@RequestBody User user, HttpServletRequest httpServletRequest){
        Map<String, Object> map = userService.login(user);
        if ((Integer) map.get("code")==0){   //登陆成功将用户信息存入session
            HttpSession session = httpServletRequest.getSession(); // 获取session
            user.setId((Integer)map.get("result"));
            session.setAttribute("user-info",user); //将用户存入session
        }
     return  map;
    }

    //用户添加自己的企业接口
    @RequestMapping("/addbusiness.action")
    public Map<String,Object> addbusiness(HttpSession session,@RequestBody Business business){
        System.out.println(business.getBusinessName());
        User user = (User) session.getAttribute("user-info");
        Map<String ,Object> map =new HashMap<>();
        if (user==null) {//判断用户是否登录
            map.put("code",1);
            map.put("error","用户未登录");
            return map;
        }

        return   userService.addbusiness(business);
    }

    //用户修改自己的企业接口
    @RequestMapping("/updatebusiness.action")
    public Map<String,Object> updatebusiness(HttpSession session,@RequestBody Business business){
        User user = (User) session.getAttribute("user-info");
        Map<String ,Object> map =new HashMap<>();
        if (user==null) {
            map.put("code",1);
            map.put("error","用户未登录");
            return  map;
        }

        return   userService.updatebusiness(business);
    }

    //用户删除自己的企业接口
    @RequestMapping("/deletebusiness.action")
    public Map<String,Object> deletebusiness(HttpSession session, Integer businessId,Integer userId){
        Map<String ,Object> map =new HashMap<>();
        User user = (User) session.getAttribute("user-info");
        if (user==null) {

            map.put("code",1);
            map.put("error","用户未登录");
           return  map;
        }
        if (businessId==null||userId==null) {
            map.put("code",1);
            map.put("error","参数错误");
            return  map;
        }
        return   userService.deletebusiness(businessId,userId);
    }
    //用户查询自己拥有的的企业接口
    @RequestMapping("/selectbusiness.action")
    public Map<String,Object> selectbusiness(HttpSession session, Integer userId){
        User user = (User) session.getAttribute("user-info");
        Map<String ,Object> map =new HashMap<>();
        if (user==null) {

            map.put("code",1);
            map.put("error","用户未登录");
        }
        if (userId==null) {
            map.put("code",1);
            map.put("error","参数错误");
        }
        return   userService.selectbusiness(userId);
    }
}

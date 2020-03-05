package com.business.Controller;

import com.business.Service.ManagerService;
import com.business.pojo.Energy;
import com.business.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ManagerService managerService;

    //管理员登录接口
    @RequestMapping("/login.action")
    public Map<String,Object> login(@RequestBody Manager manager, HttpServletRequest httpServletRequest){
        Map<String,Object> map = managerService.login(manager);
        if ((Integer) map.get("code")==0){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("admin-info",manager);
        }
        return map;
    }

    //管理员添加能源接口
    @RequestMapping("/addenergy.action")
    public Map<String,Object> addenergy(@RequestBody Energy energy, HttpSession session){
        Map<String,Object> map = new HashMap<>();
       Manager manager = (Manager)session.getAttribute("admin-info");
       if (manager==null){
           map.put("code",1);
           map.put("error","管理员未登录");
       return map;
       }
        return managerService.addenergy(energy);
    }

    //管理员修改能源接口
    @RequestMapping("/updateenergy.action")
    public Map<String,Object> updateenergy(@RequestBody Energy energy, HttpSession session){
        Map<String,Object> map = new HashMap<>();
        Manager manager = (Manager)session.getAttribute("admin-info");
        if (manager==null){
            map.put("code",1);
            map.put("error","管理员未登录");
            return map;
        }
        return managerService.updateenergy(energy);
    }

    //管理员删除能源接口
    @RequestMapping("/deleteenergy.action")
    public Map<String,Object> deleteenergy(@RequestBody Integer energyid, HttpSession session){
        Map<String,Object> map = new HashMap<>();
        Manager manager = (Manager)session.getAttribute("admin-info");
        if (manager==null){
            map.put("code",1);
            map.put("error","管理员未登录");
            return map;
        }

        return managerService.deleteenergy(energyid);
    }

    //管理员查询所有能源接口
    @RequestMapping("/selectenergys.action")
    public Map<String,Object> selectenergys( HttpSession session){
        Map<String,Object> map = new HashMap<>();
        Manager manager = (Manager)session.getAttribute("admin-info");
        if (manager==null){
            map.put("code",1);
            map.put("error","管理员未登录");
            return map;
        }
        return managerService.selectenergys();
    }

    //管理员根据能源id查询能源接口
    @RequestMapping("/selectenergy.action")
    public Map<String,Object> selectenergy( HttpSession session,Integer energyid){
        Map<String,Object> map = new HashMap<>();
        Manager manager = (Manager)session.getAttribute("admin-info");
        if (manager==null){
            map.put("code",1);
            map.put("error","管理员未登录");
            return map;
        }
        return managerService.selectenergy(energyid);
    }


}

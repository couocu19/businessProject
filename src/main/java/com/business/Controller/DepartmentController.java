package com.business.Controller;


import com.business.Service.IDepartmentService;
import com.business.common.ServletResponse;
import com.business.pojo.Department;
import com.business.pojo.Energy;
import com.business.pojo.User;
import com.business.vo.DepartmentAndEnergyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/department/")
public class DepartmentController {

    @Autowired
    private IDepartmentService iDepartmentService;

    @ResponseBody
    @RequestMapping("userAdd.action")
    public ServletResponse<DepartmentAndEnergyVo> addDepartment(HttpSession session, String name, String energy,Integer businessId,String leader,Integer energyCount){

        User user = (User)session.getAttribute("user-info");
        if(user == null){
            return ServletResponse.createByErrorMessage("用户未登录,请先登录!");
        }
        return iDepartmentService.addDepart(name,energy,businessId,leader,energyCount);
    }


    @ResponseBody
    @RequestMapping("userDelete.action")
    public ServletResponse<String> deleteDepartment(HttpSession session,Integer id){
        User user = (User)session.getAttribute("user-info");
        if(user == null){
            return ServletResponse.createByErrorMessage("用户未登录,请先登录!");
        }

        return iDepartmentService.deleteDepart(id);
    }



    @ResponseBody
    @RequestMapping("userUpdate.action")
    public ServletResponse<DepartmentAndEnergyVo> updateDepart(HttpSession session,Department department,Integer departmentId){
        User user = (User)session.getAttribute("user-info");
        if(user == null){
            return ServletResponse.createByErrorMessage("用户未登录,请先登录!");
        }

        //注意:部门的id,能源的单价,管理部门的企业id不可修改
        department.setId(departmentId);
        return iDepartmentService.updateDepart(department);

    }


    @ResponseBody
    @RequestMapping("getInfo.action")
    public ServletResponse<Department> getDepartmentInfo(HttpSession session,Integer id){
        User user = (User)session.getAttribute("user-info");
        if(user == null){
            return ServletResponse.createByErrorMessage("用户未登录,请先登录!");
        }

        return iDepartmentService.getInfo(id);
    }



    @ResponseBody
    @RequestMapping("getEnergyInfo.action")
    public ServletResponse<Energy> getEnergyInfo(HttpSession session,Integer id){
        User user = (User)session.getAttribute("user-info");
        if(user == null){
            return ServletResponse.createByErrorMessage("用户未登录,请先登录!");
        }

        return iDepartmentService.getEnergy(id);

    }

}

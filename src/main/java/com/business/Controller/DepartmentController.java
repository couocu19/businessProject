package com.business.Controller;


import com.business.Service.IDepartmentService;
import com.business.common.ServletResponse;
import com.business.pojo.Department;
import com.business.pojo.Energy;
import com.business.pojo.User;
import com.business.vo.DepartmentAndEnergyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/department/")
public class DepartmentController {

    @Autowired
    private IDepartmentService iDepartmentService;

    /**
     * 企业增加部门
     * @param session
     * @param department
     * @return
     */
    @ResponseBody
    @RequestMapping("userAdd.action")
    public ServletResponse<DepartmentAndEnergyVo> addDepartment(HttpSession session,@RequestBody Department department){

        User user = (User)session.getAttribute("user-info");
        if(user == null){
            return ServletResponse.createByErrorMessage("用户未登录,请先登录!");
        }
        Integer id = user.getId();
        System.out.println(id);
        return iDepartmentService.addDepart(department,id);
    }


    /**
     * 企业删除部门
     * @param session
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("userDelete.action")
    public ServletResponse<String> deleteDepartment(HttpSession session,Integer id){
        User user = (User)session.getAttribute("user-info");
        if(user == null){
            return ServletResponse.createByErrorMessage("用户未登录,请先登录!");
        }

        return iDepartmentService.deleteDepart(id);
    }


    /**
     * 企业更新部门信息
     * @param session
     * @param department
     * @return
     */
    @ResponseBody
    @RequestMapping("userUpdate.action")
    public ServletResponse<DepartmentAndEnergyVo> updateDepart(HttpSession session,@RequestBody Department department){
        User user = (User)session.getAttribute("user-info");
        if(user == null){
            return ServletResponse.createByErrorMessage("用户未登录,请先登录!");
        }

        //注意:部门的id,能源的单价,管理部门的企业id不可修改
        return iDepartmentService.updateDepart(department);

    }
    /**
     * 企业获取自己的所有部门
     * @param session
     * @param businessId
     * @return
     */
    @ResponseBody
    @RequestMapping("getDepartments.action")
    public ServletResponse<List<Department>> getDepartments(HttpSession session, Integer businessId){
        User user = (User)session.getAttribute("user-info");
        if(user == null){
            return ServletResponse.createByErrorMessage("用户未登录,请先登录!");
        }

        //注意:部门的id,能源的单价,管理部门的企业id不可修改
        return iDepartmentService.getDepartments(businessId);

    }

    /**
     * 企业获取部门信息
     * @param session
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("getInfo.action")
    public ServletResponse<Department> getDepartmentInfo(HttpSession session,Integer id){
        User user = (User)session.getAttribute("user-info");
        if(user == null){
            return ServletResponse.createByErrorMessage("用户未登录,请先登录!");
        }

        return iDepartmentService.getInfo(id);
    }


    /**
     * 企业获取某个部门所使用的能源信息
     * @param session
     * @param id
     * @return
     */
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

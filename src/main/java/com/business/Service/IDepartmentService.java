package com.business.Service;

import com.business.common.ServletResponse;
import com.business.pojo.Department;
import com.business.pojo.Energy;
import com.business.vo.DepartmentAndEnergyVo;

import java.util.List;

public interface IDepartmentService {
    /**
     *企业增加部门
     * @param department , id
     * @return 返回添加成功后的部门以及能源信息
     */
    ServletResponse<DepartmentAndEnergyVo> addDepart(Department department,Integer id);

    /**
     * 企业删除部门
     * @param id
     * @return 返回删除部门后的信息
     */
    ServletResponse<String> deleteDepart(Integer id);

    /**
     * 企业更新部门信息
     * @param department
     * @return 返回更新后的部门信息
     */
    ServletResponse updateDepart(Department department);

    /**
     * 企业获取部门信息
     * @param id
     * @return 对应id的部门的详细信息
     */
    ServletResponse getInfo(Integer id);

    /**
     * 企业获取某个部门所使用的能源信息
     * @param id
     * @return 返回对应id部门所使用的能源信息
     */
    ServletResponse<Energy> getEnergy(Integer id);

    ServletResponse<List<Department>> getDepartments(Integer businessId);
}

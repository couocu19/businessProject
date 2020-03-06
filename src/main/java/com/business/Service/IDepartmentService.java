package com.business.Service;

import com.business.common.ServletResponse;
import com.business.pojo.Department;
import com.business.pojo.Energy;
import com.business.vo.DepartmentAndEnergyVo;

public interface IDepartmentService {
    ServletResponse<DepartmentAndEnergyVo> addDepart(String name, String energyName, Integer businessId, String leader, Integer count);
    ServletResponse<String> deleteDepart(Integer id);
    ServletResponse updateDepart(Department department);
    ServletResponse getInfo(Integer id);
    ServletResponse<Energy> getEnergy(Integer id);
}

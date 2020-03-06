package com.business.Service.ServiceImp;

import com.business.Service.IDepartmentService;
import com.business.common.ServletResponse;
import com.business.dao.BusinessMapper;
import com.business.dao.DepartmentMapper;
import com.business.dao.EnergyMapper;
import com.business.pojo.Business;
import com.business.pojo.Department;
import com.business.pojo.Energy;
import com.business.vo.DepartmentAndEnergyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("iDepartmentService")
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EnergyMapper energyMapper;

    @Autowired
    private BusinessMapper businessMapper;

    public ServletResponse<DepartmentAndEnergyVo> addDepart(String name,String energyName,Integer businessId,String leader,Integer count){

        Department department = new Department();

        //获取待添加能源的id和单价
        Integer energyId = energyMapper.selectByName(energyName).getEnergyId();
        Double price = energyMapper.selectByName(energyName).getPrice();
        Integer allCount = energyMapper.selectByName(energyName).getCount();

        if(count>allCount){
            return ServletResponse.createByErrorMessage("能源总量不足~");
        }

        //获取管理该部门的企业的信息
        Business business = businessMapper.selectByPrimaryKey(businessId);
        if(business == null){
            return ServletResponse.createByErrorMessage("找不到该部门~");
        }


        //填充部门的具体信息
        department.setEnergy(energyName);
        department.setName(name);
        department.setEnergyId(energyId);
        department.setBusinessId(businessId);
        department.setLeader(leader);
        department.setEnergyCount(count);

        //将填好信息的部门添加到数据库中
        int rowCount = departmentMapper.insertSelective(department);
        if(rowCount>0){
            //上传成功后将pojo对象填充到视图vo对象中
            DepartmentAndEnergyVo departmentAndEnergyVo = assembleVo(price,department);
            return ServletResponse.createBySuccess(departmentAndEnergyVo);
        }

        return ServletResponse.createByErrorMessage("添加失败~");
    }

    private DepartmentAndEnergyVo assembleVo(Double price,Department department){
        DepartmentAndEnergyVo vo = new DepartmentAndEnergyVo();
        vo.setDepartName(department.getName());
        vo.setEnergyName(department.getEnergy());
        vo.setEnergyPrice(price);
        vo.setLegalPerson(department.getLeader());
        vo.setCount(department.getEnergyCount());

        return vo;
    }

    public ServletResponse<String> deleteDepart(Integer id){

        int rowCount = departmentMapper.deleteByPrimaryKey(id);
        if(rowCount>0){
            return ServletResponse.createBySuccess("ok");
        }

        return ServletResponse.createByErrorMessage("无对应的部门信息");

    }

    public ServletResponse updateDepart(Department department){
        Integer id = department.getId();
        Department currentDepartment = null;

        //检验修改的能源以及能源需求量是否存在
        String energy = department.getEnergy();
        if(energy!=null){
            Energy energy1 = energyMapper.selectByName(energy);
            if(energy1 == null){
                return ServletResponse.createByErrorMessage("能源不存在~");
            }
            Integer count = energy1.getCount();
            Integer energyCount = department.getEnergyCount();
            //判断是否修改过能源需求量
            if(energyCount!=null){
                //判断能源总量是否满足能源需求
                if(count<energyCount){
                    return ServletResponse.createByErrorMessage("能源需求量不足~");
                }
            }else {
                //判断能源总量是否满足能源需求
                currentDepartment = departmentMapper.selectByPrimaryKey(id);
                energyCount = department.getEnergyCount();
                if(count<energyCount){
                    return ServletResponse.createByErrorMessage("能源需求量不足~");
                }
            }

        }

        int rowCount = departmentMapper.updateByPrimaryKeySelective(department);
        if(rowCount>0){
            Department department1 = departmentMapper.selectByPrimaryKey(id);
            Integer energyId = department1.getEnergyId();
            Double price = energyMapper.selectByPrimaryKey(energyId).getPrice();
            DepartmentAndEnergyVo departmentAndEnergyVo = assembleVo(price,department1);
            return ServletResponse.createBySuccess("更新成功",departmentAndEnergyVo);
        }

        return ServletResponse.createByErrorMessage("更新失败~");


    }

    public ServletResponse<Department> getInfo(Integer id){
        Department department = departmentMapper.selectByPrimaryKey(id);
        if(department == null){
            return ServletResponse.createByErrorMessage("无对应企业信息~");
        }
        return ServletResponse.createBySuccess(department);
    }


    public ServletResponse<Energy> getEnergy(Integer id){
        Department department = departmentMapper.selectByPrimaryKey(id);
        if(department == null){
            return ServletResponse.createByErrorMessage("找不到对应部门~");
        }
        Integer energyId = department.getEnergyId();
        Energy energy = energyMapper.selectByPrimaryKey(energyId);
        if(energy!=null){
            return ServletResponse.createBySuccess(energy);
        }

        return ServletResponse.createByErrorMessage("查找失败~");

    }

}

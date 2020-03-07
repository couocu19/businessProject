package com.business.Service.ServiceImp;

import com.business.Service.ManagerService;
import com.business.common.Const;
import com.business.dao.EnergyMapper;
import com.business.dao.ManagerMapper;
import com.business.pojo.Energy;
import com.business.pojo.Manager;
import com.business.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("managerService")
public class ManagerServiceImp implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;
    @Autowired
    EnergyMapper energyMapper;

    @Override
    public Map<String, Object> login(Manager manager) {
        Map<String,Object> map=new HashMap<>();
        if (manager.getAccountNumber()==null||manager.getPassword()==null){
            map.put("code",1);
            map.put("error","账号密码为空");
            return  map;
        }
        String password = MD5Util.MD5EncodeUtf8(manager.getPassword(), Const.SALT);//MD5加密密码
        manager.setPassword(password);
        Manager checkmanager = managerMapper.checkManager(manager.getAccountNumber(),manager.getPassword());
        if (checkmanager==null){
            map.put("code",1);
            map.put("error","账号密码错误");
            return  map;
        }
        map.put("code",0);
        map.put("msg","ok");
        return map;
    }

    @Override
    public Map<String, Object> addenergy(Energy energy) {
        Map<String,Object> map = new HashMap<>();
        if (energy.getName()==null||energy.getPrice()==null){
            map.put("code",1);
            map.put("error","数据不完备");
            return map;
        }
        energyMapper.insertSelective(energy);
        map.put("code",0);
        map.put("msg","ok");
        return map;
    }

    @Override
    public Map<String, Object> updateenergy(Energy energy) {
        Map<String,Object> map = new HashMap<>();
        energyMapper.updateByPrimaryKeySelective(energy);//修改数据库中energy
        map.put("code",0);
        map.put("msg","ok");
        return map;
    }

    @Override
    public Map<String, Object> deleteenergy(Integer energyid) {
        Map<String,Object> map = new HashMap<>();
        if (energyid==null){
            map.put("code",1);
            map.put("error","参数错误");
            return map;
        }
        energyMapper.deleteByPrimaryKey(energyid);//根据能源编号删除
        map.put("code",0);
        map.put("msg","ok");
        return map;
    }

    @Override
    public Map<String, Object> selectenergys() {
        List<Energy> list = energyMapper.selectenergys();//查询所有的能源信息
        Map<String,Object> map =new HashMap<>();
        map.put("code",0);
        map.put("msg","ok");
        map.put("result",list);
        return map;
    }

    @Override
    public Map<String, Object> selectenergy(Integer energyid) {//根据能源id查询信息
        Map<String,Object> map = new HashMap<>();
        if (energyid==null){
            map.put("code",1);
            map.put("error","参数错误");
            return map;
        }
        Energy energy = energyMapper.selectByPrimaryKey(energyid);
        map.put("code",0);
        map.put("msg","ok");
        map.put("result",energy);
        return map;
    }
}

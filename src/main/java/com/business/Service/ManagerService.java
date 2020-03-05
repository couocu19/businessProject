package com.business.Service;

import com.business.pojo.Energy;
import com.business.pojo.Manager;

import java.util.Map;

public interface ManagerService {
    Map<String, Object> login(Manager manager);

    Map<String, Object> addenergy(Energy energy);

    Map<String, Object> updateenergy(Energy energy);

    Map<String, Object> deleteenergy(Integer energyid);

    Map<String, Object> selectenergys();

    Map<String, Object> selectenergy(Integer energyid);
}

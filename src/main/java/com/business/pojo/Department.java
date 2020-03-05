package com.business.pojo;

public class Department {
    private Integer id;

    private String name;

    private String energy;

    private Integer energyId;

    private Integer businessId;

    private String leader;

    private Integer energyCount;

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public Integer getEnergyCount() {
        return energyCount;
    }

    public void setEnergyCount(Integer energyCount) {
        this.energyCount = energyCount;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getEnergyId() {
        return energyId;
    }

    public void setEnergyId(Integer energyId) {
        this.energyId = energyId;
    }

    public Department(Integer id, String name, String energy, Integer energyId, Integer businessId, String leader, Integer energyCount) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.energyId = energyId;
        this.businessId = businessId;
        this.leader = leader;
        this.energyCount = energyCount;
    }

    public Department() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy == null ? null : energy.trim();
    }
}
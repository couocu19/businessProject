package com.business.vo;

public class DepartmentAndEnergyVo {
    private String departName;

    private String energyName;

    private double energyPrice;

    private String legalPerson;

    private Integer count;

    private Integer businessId;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public DepartmentAndEnergyVo(String departName, String energyName, double energyPrice, String legalPerson, Integer count, Integer businessId) {
        this.departName = departName;
        this.energyName = energyName;
        this.energyPrice = energyPrice;
        this.legalPerson = legalPerson;
        this.count = count;
        this.businessId = businessId;
    }

    public DepartmentAndEnergyVo(){
        super();
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getEnergyName() {
        return energyName;
    }

    public void setEnergyName(String energyName) {
        this.energyName = energyName;
    }

    public double getEnergyPrice() {
        return energyPrice;
    }

    public void setEnergyPrice(double energyPrice) {
        this.energyPrice = energyPrice;
    }
}

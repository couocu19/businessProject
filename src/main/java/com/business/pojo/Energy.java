package com.business.pojo;

public class Energy {
    private Integer energyId;

    private String name;

    private Double price;

    private Integer summation;

    private Integer demand;

    public Energy(Integer energyId, String name, Double price, Integer summation, Integer demand) {
        this.energyId = energyId;
        this.name = name;
        this.price = price;
        this.summation = summation;
        this.demand = demand;
    }

    public Energy() {
        super();
    }

    public Integer getEnergyId() {
        return energyId;
    }

    public void setEnergyId(Integer energyId) {
        this.energyId = energyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSummation() {
        return summation;
    }

    public void setSummation(Integer summation) {
        this.summation = summation;
    }

    public Integer getDemand() {
        return demand;
    }

    public void setDemand(Integer demand) {
        this.demand = demand;
    }
}
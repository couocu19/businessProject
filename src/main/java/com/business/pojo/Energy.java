package com.business.pojo;

public class Energy {
    private Integer energyId;

    private String name;

    private Double price;

    private Integer count;

    public Energy(Integer energyId, String name, Double price, Integer count) {
        this.energyId = energyId;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
}
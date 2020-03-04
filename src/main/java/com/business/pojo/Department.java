package com.business.pojo;

public class Department {
    private Integer id;

    private String name;

    private String energy;

    public Department(Integer id, String name, String energy) {
        this.id = id;
        this.name = name;
        this.energy = energy;
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
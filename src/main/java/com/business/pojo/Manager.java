package com.business.pojo;

public class Manager {
    private Integer id;

    private Integer energyId;

    private String accountNumber;

    private String password;

    public Manager(Integer id, Integer energyId, String accountNumber, String password) {
        this.id = id;
        this.energyId = energyId;
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public Manager() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnergyId() {
        return energyId;
    }

    public void setEnergyId(Integer energyId) {
        this.energyId = energyId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
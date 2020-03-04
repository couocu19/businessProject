package com.business.pojo;

public class User {
    private Integer id;

    private String accountNumber;

    private String password;

    private Integer businessId;

    public User(Integer id, String accountNumber, String password, Integer businessId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.password = password;
        this.businessId = businessId;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }
}
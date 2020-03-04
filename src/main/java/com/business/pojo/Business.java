package com.business.pojo;

public class Business {
    private Integer businessId;

    private Integer id;

    private String businessName;

    private String legalPersion;

    private String type;

    public Business(Integer businessId, Integer id, String businessName, String legalPersion, String type) {
        this.businessId = businessId;
        this.id = id;
        this.businessName = businessName;
        this.legalPersion = legalPersion;
        this.type = type;
    }

    public Business() {
        super();
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public String getLegalPersion() {
        return legalPersion;
    }

    public void setLegalPersion(String legalPersion) {
        this.legalPersion = legalPersion == null ? null : legalPersion.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}
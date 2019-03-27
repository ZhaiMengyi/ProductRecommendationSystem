package com.zmy.entity;

public class Merchant {
    private Integer merId;
    private String merUsername;
    private String merPassword;
    private String merShopName;
    private String merMobile;
    private String merAddress;
    private Integer merStatus;

    public Merchant() {
    }

    public Merchant(Integer merId, String merUsername, String merPassword, String merShopName, String merMobile, String merAddress) {
        this.merId = merId;
        this.merUsername = merUsername;
        this.merPassword = merPassword;
        this.merShopName = merShopName;
        this.merMobile = merMobile;
        this.merAddress = merAddress;
    }

    public Merchant(String merUsername, String merPassword, String merShopName, String merMobile, String merAddress) {
        this.merUsername = merUsername;
        this.merPassword = merPassword;
        this.merShopName = merShopName;
        this.merMobile = merMobile;
        this.merAddress = merAddress;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
    }

    public String getMerUsername() {
        return merUsername;
    }

    public void setMerUsername(String merUsername) {
        this.merUsername = merUsername;
    }

    public String getMerPassword() {
        return merPassword;
    }

    public void setMerPassword(String merPassword) {
        this.merPassword = merPassword;
    }

    public String getMerShopName() {
        return merShopName;
    }

    public void setMerShopName(String merShopname) {
        this.merShopName = merShopname;
    }

    public String getMerMobile() {
        return merMobile;
    }

    public void setMerMobile(String merMobile) {
        this.merMobile = merMobile;
    }

    public String getMerAddress() {
        return merAddress;
    }

    public void setMerAddress(String merAddress) {
        this.merAddress = merAddress;
    }

    public Integer getMerStatus() {
        return merStatus;
    }

    public void setMerStatus(Integer merStatus) {
        this.merStatus = merStatus;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "merId=" + merId +
                ", merUsername='" + merUsername + '\'' +
                ", merPassword='" + merPassword + '\'' +
                ", merShopName='" + merShopName + '\'' +
                ", merMobile='" + merMobile + '\'' +
                ", merAddress='" + merAddress + '\'' +
                ", merStatus=" + merStatus +
                '}';
    }
}

package com.gaoxh.videoapk.bean;

public class UserInfo {
    private long id;
    private String icUrl;
    private String name;
    private String account;
    private String level;

    public UserInfo() {
    }

    public UserInfo(long id, String icUrl, String name, String account, String level) {
        this.id = id;
        this.icUrl = icUrl;
        this.name = name;
        this.account = account;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIcUrl() {
        return icUrl;
    }

    public void setIcUrl(String icUrl) {
        this.icUrl = icUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", icUrl='" + icUrl + '\'' +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}

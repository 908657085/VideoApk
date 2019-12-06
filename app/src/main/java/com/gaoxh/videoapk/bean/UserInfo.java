package com.gaoxh.videoapk.bean;

public class UserInfo {
    private long id;
    private String userName;
    private String pwd;
    private String userLevel;
    private String userIcon;
    public UserInfo() {
    }

    public UserInfo(long id, String userName, String pwd, String userLevel, String userIcon) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.userLevel = userLevel;
        this.userIcon = userIcon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", userIcon='" + userIcon + '\'' +
                '}';
    }
}

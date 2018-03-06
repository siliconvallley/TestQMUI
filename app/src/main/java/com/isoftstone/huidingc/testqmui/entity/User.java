package com.isoftstone.huidingc.testqmui.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 用户实体对象
 * Created by issuser on 2017/11/17.
 */
@Entity
public class User {

    @Id(autoincrement = true)
    private Long id;
    /**
     * userId : 1
     * userName : admin
     * password : null
     * realName : null
     * activeTime : null
     * userStatus : null
     * phone : null
     * duty : null
     * branch : null
     * sex : null
     * eamil : null
     * jionTime : null
     * integral : null
     * totalIntegral : null
     * unit : null
     * role : null
     * img : null
     * relation : null
     * uid : null
     * braPm:null
     * "token":"a8a01e73-c5d2-40d4-9443-bbde5d00d9fe"
     */

    private int userId;
    private String userName;
    private String password;
    private String realName;
    private String activeTime;
    private String userStatus;
    private String phone;
    private String duty;
    private String branch;
    private String sex;
    private String eamil;
    private String jionTime;
    private String integral;
    private String totalIntegral;
    private String unit;
    private int role;
    private String img;
    private String relation;
    private String uid;
    private String token;
    private String braPm;

    @Generated(hash = 1942676471)
    public User(Long id, int userId, String userName, String password,
            String realName, String activeTime, String userStatus, String phone,
            String duty, String branch, String sex, String eamil, String jionTime,
            String integral, String totalIntegral, String unit, int role,
            String img, String relation, String uid, String token, String braPm) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.activeTime = activeTime;
        this.userStatus = userStatus;
        this.phone = phone;
        this.duty = duty;
        this.branch = branch;
        this.sex = sex;
        this.eamil = eamil;
        this.jionTime = jionTime;
        this.integral = integral;
        this.totalIntegral = totalIntegral;
        this.unit = unit;
        this.role = role;
        this.img = img;
        this.relation = relation;
        this.uid = uid;
        this.token = token;
        this.braPm = braPm;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getJionTime() {
        return jionTime;
    }

    public void setJionTime(String jionTime) {
        this.jionTime = jionTime;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getTotalIntegral() {
        return totalIntegral;
    }

    public void setTotalIntegral(String totalIntegral) {
        this.totalIntegral = totalIntegral;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBraPm() {
        return braPm;
    }

    public void setBraPm(String braPm) {
        this.braPm = braPm;
    }
}

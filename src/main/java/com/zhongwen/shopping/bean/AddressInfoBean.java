package com.zhongwen.shopping.bean;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 00:32
 **/
public class AddressInfoBean {

    /**
     * 用户地址ID
     */
    private Integer id;

    /**
     * 用户openId
     */
    private String userOpenId;

    /**
     * 收件人
     */
    private String name;

    /**
     * 收件人手机号
     */
    private String phone;

    /**
     * 省份
     */
    private String provice;

    /**
     * 城市
     */
    private String city;

    /**
     * 县级
     */
    private String country;

    /**
     * 地址详情
     */
    private String detail;

    /**
     * 是否是默认地址 状态1 默认； 0 不是
     */
    private Integer defaultStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public AddressInfoBean() {
    }

    @Override
    public String toString() {
        return "AddressInfoBean{" +
                "id=" + id +
                ", userOpenId='" + userOpenId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", provice='" + provice + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", detail='" + detail + '\'' +
                ", defaultStatus='" + defaultStatus + '\'' +
                '}';
    }
}

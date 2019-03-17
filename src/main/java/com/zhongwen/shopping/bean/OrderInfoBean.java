package com.zhongwen.shopping.bean;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 19:39
 **/
public class OrderInfoBean {

    /**
     * 订单id
     */
    private Integer id;

    /**
     * 用户地址信息
     */
    private Integer addressId;

    /**
     * 下单时间
     */
    private String date;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 用户openId
     */
    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "OrderInfoBean{" +
                "id=" + id +
                ", addressId=" + addressId +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", openId='" + openId + '\'' +
                '}';
    }
}

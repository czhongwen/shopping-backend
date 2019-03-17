package com.zhongwen.shopping.bean;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 21:01
 **/
public class OrderDetailBean {

    /**
     * 用户订单ID
     */
    private Integer orderId;

    /**
     * 产品ID
     */
    private Integer productId;

    /**
     * 订单数量
     */
    private Integer productNum;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    @Override
    public String toString() {
        return "OrderDetailBean{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", productNum=" + productNum +
                '}';
    }
}

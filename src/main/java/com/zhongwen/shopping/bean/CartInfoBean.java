package com.zhongwen.shopping.bean;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 09:21
 **/
public class CartInfoBean {

    /**
     * 购物车id
     */
    private Integer cartId;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * openId
     */
    private String openId;

    public CartInfoBean() {
    }

    /**
     * 商品数量
     */


    private Integer productNum;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    @Override
    public String toString() {
        return "CartInfoBean{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                ", openId='" + openId + '\'' +
                ", productNum=" + productNum +
                '}';
    }
}

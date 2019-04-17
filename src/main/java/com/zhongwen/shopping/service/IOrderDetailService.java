package com.zhongwen.shopping.service;

import com.zhongwen.shopping.bean.ProductInfoBean;

import java.util.List;
import java.util.Map;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-19 00:04
 **/
public interface IOrderDetailService {
    /**
     * 获取下单次数最多的商品
     * @return
     */
    List<ProductInfoBean> getHotProducts();

    /**
     * 获取用户的订单
     * @param openId
     * @return
     */
    List<Map> getOrdersByOpenId(String openId);
}

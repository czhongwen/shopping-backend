package com.zhongwen.shopping.service;

import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.bean.ProductInfoBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-19 00:04
 **/
@Transactional
public interface IOrderService {
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

    /**
     * 用户下单
     * @param prams
     * @return
     */
    Boolean addOrders(JSONObject prams);
}

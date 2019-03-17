package com.zhongwen.shopping.dao;

import com.zhongwen.shopping.bean.OrderInfoBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 19:47
 **/
@Service
public interface IOrderInfoDAO {

    /**
     * 根据openID查询用户的订单
     * @param openId
     * @return
     */
    List<OrderInfoBean> getOrderInfoList(String openId);

    /**
     * 修改用户订单
     * @param orderInfoBean
     * @return
     */
    int updateOrderInfo(OrderInfoBean orderInfoBean);

    /**
     * 增加订单
     * @param orderInfoBean
     * @return
     */
    int addOrderInfo(OrderInfoBean orderInfoBean);

}

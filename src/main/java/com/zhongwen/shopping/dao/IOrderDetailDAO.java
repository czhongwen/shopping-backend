package com.zhongwen.shopping.dao;

import com.zhongwen.shopping.bean.OrderDetailBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 21:06
 **/
@Service
public interface IOrderDetailDAO {

    /**
     * 添加订单详情
     * @param orderDetailBeanList
     * @return
     */
    int addOrderDetail(List<OrderDetailBean> orderDetailBeanList);

    /**
     * 根据订单号获取订单详情
     * @param orderId
     * @return
     */
    List<OrderDetailBean> getOrderDetailList(Integer orderId);

    /**
     * 下单次数最多的十件商品
     * @return
     */
    List<Integer> getHotProduct();

    /**
     * 根据订单号查询订详情
     * @param ids
     * @return
     */
    List<OrderDetailBean> getByIds(List<Integer> ids);
}

package com.zhongwen.shopping.service.impl;

import com.zhongwen.shopping.bean.OrderDetailBean;
import com.zhongwen.shopping.bean.OrderInfoBean;
import com.zhongwen.shopping.bean.ProductInfoBean;
import com.zhongwen.shopping.dao.IOrderDetailDAO;
import com.zhongwen.shopping.dao.IOrderInfoDAO;
import com.zhongwen.shopping.dao.IProductInfoDAO;
import com.zhongwen.shopping.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-19 00:06
 **/
@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    IOrderDetailDAO orderDetailDAO;
    @Autowired
    IProductInfoDAO productInfoDAO;
    @Autowired
    IOrderInfoDAO orderInfoDAO;

    @Override
    public List<ProductInfoBean> getHotProducts() {

        List<Integer> productIds = orderDetailDAO.getHotProduct();

        List<ProductInfoBean> productInfoBeans = productInfoDAO.getProducts(productIds);

        return productInfoBeans;
    }

    @Override
    public List<Map> getOrdersByOpenId(String openId) {
        if (openId == null ) {
            throw new RuntimeException("参数异常!");
        }

        List<OrderInfoBean> orderInfoBeans = orderInfoDAO.getOrderInfoList(openId);

        if (orderInfoBeans.size() <= 0) {
            return new ArrayList<>();
        }

        List<Integer> orderIds = new ArrayList<>();

        for (OrderInfoBean orderInfoBean : orderInfoBeans) {
            orderIds.add(orderInfoBean.getId());
        }

        List<OrderDetailBean> orderDetailBeans = orderDetailDAO.getByIds(orderIds);

        if (CollectionUtils.isEmpty(orderDetailBeans)) {
            return new ArrayList<>();
        }

        List<Integer> productIds = new ArrayList<>();
        Map<Integer, Integer> maps = new HashMap<>();
        for (OrderDetailBean orderDetailBean : orderDetailBeans) {
            productIds.add(orderDetailBean.getProductId());
            maps.put(orderDetailBean.getProductId(), orderDetailBean.getProductNum());
        }

        List<ProductInfoBean> productInfoBeans = productInfoDAO.getProducts(productIds);

        List<Map> result = new ArrayList<>();
        for (ProductInfoBean productInfoBean : productInfoBeans) {
            Map temp = new HashMap();
            temp.put("productId", productInfoBean.getId());
            temp.put("image", productInfoBean.getImage1());
            temp.put("info", productInfoBean.getInfo());
            temp.put("name", productInfoBean.getName());
            temp.put("num", maps.get(productInfoBean.getId()));
            result.add(temp);
        }

        return result;
    }
}

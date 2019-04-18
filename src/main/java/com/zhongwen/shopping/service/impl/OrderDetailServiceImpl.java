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

        if (CollectionUtils.isEmpty(orderInfoBeans)) {
            return new ArrayList<>();
        }

        List<Integer> orderIds = new ArrayList<>();

        List<Map> orderInfos = new ArrayList<>();
        for (OrderInfoBean orderInfoBean : orderInfoBeans) {
            orderIds.add(orderInfoBean.getId());
            Map orderInfoMap = new HashMap();
            orderInfoMap.put("orderId", orderInfoBean.getId());
            orderInfoMap.put("addressId", orderInfoBean.getAddressId());
            orderInfoMap.put("time", orderInfoBean.getDate());
            orderInfoMap.put("status", orderInfoBean.getStatus());
            orderInfoMap.put("list", new ArrayList<Map>());
            orderInfos.add(orderInfoMap);
        }

        List<OrderDetailBean> orderDetailBeans = orderDetailDAO.getByIds(orderIds);

        if (CollectionUtils.isEmpty(orderDetailBeans)) {
            return new ArrayList<>();
        }

        List<Integer> productIds = new ArrayList<>();
        Map orderDetailMap = new HashMap();
        for (OrderDetailBean orderDetailBean : orderDetailBeans) {
            productIds.add(orderDetailBean.getProductId());
            orderDetailMap.put(orderDetailBean.getOrderId(), orderDetailBean.getProductNum());
            orderDetailMap.put(orderDetailBean.getProductId(), orderDetailBean.getOrderId());
        }

        List<ProductInfoBean> productInfoBeans = productInfoDAO.getProducts(productIds);

        if (CollectionUtils.isEmpty(productInfoBeans)) {
            return new ArrayList<>();
        }

        List<Map> orderDetails = new ArrayList<>();
        for (ProductInfoBean productInfoBean : productInfoBeans) {
            Map temp = new HashMap();
            temp.put("image", productInfoBean.getImage1());
            temp.put("name", productInfoBean.getName());
            temp.put("info", productInfoBean.getInfo());
            temp.put("num", orderDetailMap.get(orderDetailMap.get(productInfoBean.getId())));
            temp.put("orderId", orderDetailMap.get(productInfoBean.getId()));
            temp.put("detail", productInfoBean.getDetail());
            orderDetails.add(temp);
        }

        for (Map orderInfoMap : orderInfos) {
            for (Map orderDetailMaps : orderDetails) {
                if ( orderInfoMap.get("orderId").equals(orderDetailMaps.get("orderId")) ) {
                    List<Map> map = (ArrayList<Map>)orderInfoMap.get("list");
                    orderDetailMaps.put("status", orderInfoMap.get("status"));
                    map.add(orderDetailMaps);
                    orderInfoMap.put("list", map);
                }
            }
        }

        return orderInfos;
    }
}

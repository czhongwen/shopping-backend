package com.zhongwen.shopping.service.impl;

import com.zhongwen.shopping.bean.ProductInfoBean;
import com.zhongwen.shopping.dao.IOrderDetailDAO;
import com.zhongwen.shopping.dao.IProductInfoDAO;
import com.zhongwen.shopping.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ProductInfoBean> getHotProducts() {

        List<Integer> productIds = orderDetailDAO.getHotProduct();

        List<ProductInfoBean> productInfoBeans = productInfoDAO.getProducts(productIds);

        return productInfoBeans;
    }
}

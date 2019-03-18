package com.zhongwen.shopping.service;

import com.zhongwen.shopping.bean.ProductInfoBean;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-19 00:04
 **/
public interface IOrderDetailService {

    List<ProductInfoBean> getHotProducts();

}

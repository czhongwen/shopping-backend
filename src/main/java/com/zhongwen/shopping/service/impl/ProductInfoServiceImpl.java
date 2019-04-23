package com.zhongwen.shopping.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.bean.ProductInfoBean;
import com.zhongwen.shopping.dao.IProductInfoDAO;
import com.zhongwen.shopping.service.IProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-24 00:39
 **/
@Service
public class ProductInfoServiceImpl implements IProductInfoService {

    @Autowired
    IProductInfoDAO productInfoDAO;

    @Override
    public ProductInfoBean getProductById(Integer id) {

        if (id == null || id < 0) {
            throw new RuntimeException("参数错误！");
        }

        return productInfoDAO.getProductInfoById(id);
    }

    @Override
    public JSONObject getProductInfoByTypeId(ProductInfoBean productInfoBean) {

        productInfoBean.setStatus(1);
        if (productInfoBean.getIndexDetailId() == null ) {
            throw new RuntimeException("查询的商品的类型为空！");
        }

        if (productInfoBean.getOffset() < 0 ) {
            productInfoBean.setOffset(0);
        }

        if (productInfoBean.getLimit() <= 0) {
            productInfoBean.setLimit(8);
        }
        //获得商品总数
        int count = productInfoDAO.getProductCount(productInfoBean);

        List<ProductInfoBean> productInfoBeans = productInfoDAO.getProductInfoByIndexDetailId(productInfoBean);

        JSONObject result = new JSONObject();
        result.put("count", count);
        result.put("list", productInfoBeans);
        result.put("offset", productInfoBean.getOffset());
        return result;
    }

    @Override
    public JSONObject getProductFullInfoByIndexDetailId(ProductInfoBean productInfoBean) {
        if (productInfoBean.getIndexDetailId() == null ) {
            throw new RuntimeException("查询的商品的类型为空！");
        }

        if (productInfoBean.getOffset() < 0 ) {
            productInfoBean.setOffset(0);
        }

        if (productInfoBean.getLimit() <= 0) {
            productInfoBean.setLimit(8);
        }

        ProductInfoBean productInfoBean1 = new ProductInfoBean();
        productInfoBean1.setStatus(productInfoBean.getStatus());
        productInfoBean1.setIndexDetailId(productInfoBean.getIndexDetailId());
        //获得商品总数
        int count = productInfoDAO.getProductCount(productInfoBean1);

        List<ProductInfoBean> productInfoBeans = productInfoDAO.getProductFullInfoByIndexDetailId(productInfoBean);

        JSONObject result = new JSONObject();
        result.put("count", count);
        result.put("list", productInfoBeans);
        result.put("offset", productInfoBean.getOffset());
        return result;
    }

    @Override
    public Boolean updateProduct(ProductInfoBean productInfoBean) {
        if (productInfoBean.getId() <= 0 ) {
            throw new RuntimeException("参数错误！");
        }
        productInfoDAO.updateProductInfo(productInfoBean);
        return true;
    }
}

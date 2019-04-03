package com.zhongwen.shopping.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.bean.CartInfoBean;
import com.zhongwen.shopping.bean.ProductInfoBean;
import com.zhongwen.shopping.dao.ICartInfoDAO;
import com.zhongwen.shopping.dao.IProductInfoDAO;
import com.zhongwen.shopping.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-24 22:45
 **/
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartInfoDAO cartInfoDAO;

    @Autowired
    private IProductInfoDAO productInfoDAO;

    @Override
    public JSONArray getCartByOpenId(String openId) {

        if (StringUtils.isEmpty(openId)) {
            throw new RuntimeException("丢失了一些重要信息,请重新登陆小程序");
        }

        List<CartInfoBean> cartInfoBeans = cartInfoDAO.getCartsList(openId);

        if (cartInfoBeans == null) {
            throw new RuntimeException("");
        }

        //获取商品id
        List<Integer> ids = new ArrayList<>();
        for (CartInfoBean cartInfoBean : cartInfoBeans) {
            ids.add(cartInfoBean.getProductId());
        }

        List<ProductInfoBean> productInfoBeans = productInfoDAO.getProducts(ids);

        //封装查询到的数据
        JSONArray array = new JSONArray();
        for (CartInfoBean cartInfoBean : cartInfoBeans) {

            JSONObject object = new JSONObject();
            object.put("id", cartInfoBean.getCartId());
            object.put("productId", cartInfoBean.getProductId());
            object.put("num", cartInfoBean.getProductNum());

            for (ProductInfoBean productInfoBean : productInfoBeans) {

                if (productInfoBean.getId().equals(cartInfoBean.getProductId())) {

                    object.put("name", productInfoBean.getName());
                    object.put("info", productInfoBean.getInfo());
                    object.put("price", productInfoBean.getPrice());
                    object.put("image", productInfoBean.getImage1());

                    break;
                }
            }

            array.add(object);
        }

        return  array;
    }

    @Override
    public Boolean delAllCartsByOpenId(String openId) {

        return true;
    }

    @Override
    public Boolean delCartsByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public Boolean addCarts(List<CartInfoBean> cartInfoBeans) {
        return null;
    }
}

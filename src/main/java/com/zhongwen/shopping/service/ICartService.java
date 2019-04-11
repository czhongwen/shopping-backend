package com.zhongwen.shopping.service;

import com.alibaba.fastjson.JSONArray;
import com.zhongwen.shopping.bean.CartInfoBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-24 22:41
 **/
public interface ICartService {

    /**
     * 根据openId获取购物车
     * @param openId
     * @return
     * @throws Exception
     */
    JSONArray getCartByOpenId(String openId);

    /**
     * 根据用户的openid删除用户的购物车
     * @param openId
     * @return
     * @throws Exception
     */
    Boolean delAllCartsByOpenId(String openId);

    /**
     * 根据ids删除用户的购物车
     * @param ids
     * @return
     * @throws Exception
     */
    Boolean delCartsByIds(List<Integer> ids);

    /**
     * 增加用户的购物车
     * @param cartInfoBeans
     * @return
     * @throws Exception
     */
    Boolean addCarts(List<CartInfoBean> cartInfoBeans);

    /**
     * 根据id删除购物车
     * @param id
     * @return
     */
    Boolean delCartById(Integer id);

    /**
     * 添加购物车
     * @param cartInfoBean
     * @return
     */
    Boolean addCart(CartInfoBean cartInfoBean);
}

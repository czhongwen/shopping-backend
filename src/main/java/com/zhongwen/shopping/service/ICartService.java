package com.zhongwen.shopping.service;

import com.alibaba.fastjson.JSONArray;

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
    JSONArray getCartByOpenId(String openId) throws Exception;

}

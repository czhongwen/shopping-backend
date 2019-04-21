package com.zhongwen.shopping.service;

import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.bean.ProductInfoBean;

import java.util.List;
import java.util.Map;


/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-24 00:37
 **/
public interface IProductInfoService {

    /**
     * 根据ID查询商品详情
     * @param id
     * @return
     */
    ProductInfoBean getProductById (Integer id);

    /**
     * 根据typeId查询商品列表【提供给前台，后台不要调用这个接口】
     * @param productInfoBean
     * @return
     * @throws Exception
     */
    JSONObject getProductInfoByTypeId(ProductInfoBean productInfoBean);

    /**
     * 根据typeId查询商品列表[信息完整仅提供给后台]
     * @param productInfoBean
     * @return
     */
    JSONObject getProductFullInfoByIndexDetailId(ProductInfoBean productInfoBean);
}

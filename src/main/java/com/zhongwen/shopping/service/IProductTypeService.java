package com.zhongwen.shopping.service;

import com.alibaba.fastjson.JSONArray;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-24 10:17
 **/
public interface IProductTypeService  {

    /**
     * 获得所有商品分类信息
     * @return
     */
    JSONArray getAllType ();

//    /**
//     * 获取一级分类
//     * @return
//     */
//    List<IndexTypeBean> getPrimaryClassification();
//
//    /**
//     * 获取二级分类
//     * @return
//     */
//    List<IndexDeailBean> getSecondaryClassification();
}

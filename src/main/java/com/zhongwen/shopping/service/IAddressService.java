package com.zhongwen.shopping.service;

import com.zhongwen.shopping.bean.AddressInfoBean;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-04-11 23:36
 **/
public interface IAddressService {

    /**
     * 获取应用的地址
     * @param openId
     * @return
     */
    List<AddressInfoBean> getAddresss(String openId);

}

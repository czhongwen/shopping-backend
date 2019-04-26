package com.zhongwen.shopping.service;

import com.zhongwen.shopping.bean.AddressInfoBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-04-11 23:36
 **/
@Transactional
public interface IAddressService {

    /**
     * 获取应用的地址
     * @param openId
     * @return
     */
    List<AddressInfoBean> getAddresss(String openId);

    /**
     * 删除收货地址
     * @param id
     * @return
     */
    Boolean delAddress(Integer id);

    /**
     * 用户修改地址
     * @param addressInfoBean
     * @return
     */
    Boolean updateAddress(AddressInfoBean addressInfoBean);

    /**
     * 用户增加收货地址
     * @param addressInfoBean
     * @return
     */
    Boolean addAddress(AddressInfoBean addressInfoBean);

    /**
     * 获取默认地址
     * @param openId
     * @return
     */
    AddressInfoBean getDefaultAddress(String openId);
}

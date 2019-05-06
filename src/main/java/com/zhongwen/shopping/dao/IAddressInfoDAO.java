package com.zhongwen.shopping.dao;

import com.zhongwen.shopping.bean.AddressInfoBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 00:47
 **/
@Service
public interface IAddressInfoDAO {

    /**
     * 根据openId查询用户的收获地址
     * @param openId
     * @return
     */
    List<AddressInfoBean> getListAddInfoByOpenId(String openId);

    /**
     * 用户修改地址
     * @param addressInfoBean
     * @return
     */
    int updateAddressInfo(AddressInfoBean addressInfoBean);

    /**
     * 添加收货地址
     * @param addressInfoBean
     * @return
     */
    int addAddress(AddressInfoBean addressInfoBean);

    /**
     * 根据openID获取默认地址
     * @param openId
     * @return
     */
    AddressInfoBean getDefaultAddress(String openId);

    /**
     * 修改默认地址
     * @param addressInfoBean
     * @return
     */
    Integer updateDefaultAddress(AddressInfoBean addressInfoBean);

    /**
     * 根据id获得地址
     * @param id
     * @return
     */
    AddressInfoBean getById(Integer id);
}

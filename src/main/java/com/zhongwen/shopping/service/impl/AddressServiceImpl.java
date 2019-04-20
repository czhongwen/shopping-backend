package com.zhongwen.shopping.service.impl;

import com.zhongwen.shopping.bean.AddressInfoBean;
import com.zhongwen.shopping.dao.IAddressInfoDAO;
import com.zhongwen.shopping.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-04-11 23:38
 **/
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    IAddressInfoDAO addressInfoDAO;

    @Override
    public List<AddressInfoBean> getAddresss(String openId) {

        if (StringUtils.isEmpty(openId)) {
            throw new RuntimeException("丢失重要信息,请尝试重新登陆");
        }

        List<AddressInfoBean> addressInfoBeanList = addressInfoDAO.getListAddInfoByOpenId(openId);

        return addressInfoBeanList;
    }

    @Override
    public Boolean delAddress(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("参数异常!");
        }

        AddressInfoBean addressInfoBean = new AddressInfoBean();
        addressInfoBean.setId(id);
        addressInfoBean.setDefaultStatus(3);

        return addressInfoDAO.updateAddressInfo(addressInfoBean) > 0;
    }

    @Override
    public Boolean updateAddress(AddressInfoBean addressInfoBean) {

        if (StringUtils.isEmpty(addressInfoBean.getUserOpenId())) {
            throw new RuntimeException("参数错误!");
        }

        if (addressInfoBean.getDefaultStatus() == 1) {
            this.updateDefaultAddress(addressInfoBean);
        }

        return addressInfoDAO.updateAddressInfo(addressInfoBean) > 0;
    }

    @Override
    public Boolean addAddress(AddressInfoBean addressInfoBean) {

        if (addressInfoBean.getUserOpenId() == null) {
            throw new RuntimeException("参数错误!");
        }

        if (addressInfoBean.getDefaultStatus() == 1) {
            this.updateDefaultAddress(addressInfoBean);
        }

        return addressInfoDAO.addAddress(addressInfoBean) > 0;
    }

    @Override
    public AddressInfoBean getDefaultAddress(String openId) {
        if (StringUtils.isEmpty(openId)) {
            throw new RuntimeException("参数错误!");
        }
        return addressInfoDAO.getDefaultAddress(openId);
    }

    private boolean updateDefaultAddress(AddressInfoBean addressInfoBean) {

        return addressInfoDAO.updateDefaultAddress(addressInfoBean) > 0 ;

    }
}

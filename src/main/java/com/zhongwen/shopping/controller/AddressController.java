package com.zhongwen.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.bean.AddressInfoBean;
import com.zhongwen.shopping.service.IAddressService;
import com.zhongwen.shopping.util.ResultGenerator;
import com.zhongwen.shopping.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-04-11 23:34
 **/
@RestController
@ResponseBody
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @RequestMapping(value = "/getAddressList", method = RequestMethod.POST)
    public ResultVO getAddresss(@RequestBody JSONObject prams) {
        String openId = prams.getString("openId");
        return ResultGenerator.successResult(addressService.getAddresss(openId));
    }

    @RequestMapping(value = "/delAddress", method = RequestMethod.POST)
    public ResultVO delAddress(@RequestBody JSONObject prams) {
        Integer id = prams.getInteger("id");
        return ResultGenerator.successResult(addressService.delAddress(id));
    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    public ResultVO updateAddrss(@RequestBody AddressInfoBean addressInfoBean) {
        return ResultGenerator.successResult(addressService.updateAddress(addressInfoBean));
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public ResultVO addAddress(@RequestBody AddressInfoBean addressInfoBean) {
        return ResultGenerator.successResult(addressService.addAddress(addressInfoBean));
    }

    @RequestMapping(value = "/getDefault", method = RequestMethod.POST)
    public ResultVO getDefaultAddress(@RequestBody JSONObject prams) {
        return ResultGenerator.successResult(addressService.getDefaultAddress(prams.getString("openId")));
    }
}

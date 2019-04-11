package com.zhongwen.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.bean.CartInfoBean;
import com.zhongwen.shopping.service.ICartService;
import com.zhongwen.shopping.util.ResultGenerator;
import com.zhongwen.shopping.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-24 22:34
 **/
@Controller
@ResponseBody
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @RequestMapping(value = "/getCarts", method = RequestMethod.POST)
    public ResultVO getCartsByOpenId(@RequestBody JSONObject prams) {
        String openId = prams.getString("openId");
        return ResultGenerator.successResult(cartService.getCartByOpenId(openId));
    }

    @RequestMapping(value = "/delAll", method = RequestMethod.POST)
    public ResultVO delAllCarts(String openId) {
        return ResultGenerator.successResult(true);
    }

    @RequestMapping(value = "/delCartById")
    public ResultVO delCartById(@RequestBody JSONObject prams) {
        Integer id = prams.getInteger("id");
        return ResultGenerator.successResult(cartService.delCartById(id));
    }

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public ResultVO addCart(@RequestBody JSONObject prams) {
        CartInfoBean cartInfoBean = new CartInfoBean();
        cartInfoBean.setProductId(prams.getInteger("productId"));
        cartInfoBean.setOpenId(prams.getString("openId"));
        cartInfoBean.setProductNum(prams.getInteger("num"));
        return ResultGenerator.successResult(cartService.addCart(cartInfoBean));
    }
}

package com.zhongwen.shopping.controller;

import com.alibaba.fastjson.JSONObject;
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
        try {
            String openId = prams.getString("openId");
            return ResultGenerator.successResult(cartService.getCartByOpenId(openId));
        } catch (Exception e) {
            return ResultGenerator.failResult("请求异常:", e);
        }
    }

}

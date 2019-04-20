package com.zhongwen.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.service.IOrderService;
import com.zhongwen.shopping.util.ResultGenerator;
import com.zhongwen.shopping.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-04-17 11:36
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/getOrders", method = RequestMethod.POST)
    public ResultVO getOrder(@RequestBody JSONObject prams) {
        return ResultGenerator.successResult(orderService.getOrdersByOpenId(prams.getString("openId")));
    }

    @RequestMapping(value = "/addOrders", method = RequestMethod.POST)
    public ResultVO addOrder(@RequestBody JSONObject prams) {
        return ResultGenerator.successResult(orderService.addOrders(prams));
    }

}

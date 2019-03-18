package com.zhongwen.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.service.impl.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-19 00:01
 **/
@Controller
@RequestMapping(value = "/index")
@ResponseBody
public class IndexController {

    @Autowired
    OrderDetailServiceImpl orderDetailService;

    @RequestMapping(value = "/getHot", method = RequestMethod.POST)
    public JSONObject getHotProducts() {

        JSONObject result = new JSONObject();

        try {
            result.put("result", orderDetailService.getHotProducts());
        } catch (Exception e) {
            result.put("系统异常", e.getMessage());
        }
        return result;
    }

}
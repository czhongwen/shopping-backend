package com.zhongwen.shopping.controller;

import com.zhongwen.shopping.service.IOrderService;
import com.zhongwen.shopping.util.ResultGenerator;
import com.zhongwen.shopping.util.ResultVO;
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
    private IOrderService orderService;

    @RequestMapping(value = "/getHot", method = RequestMethod.POST)
    public ResultVO getHotProducts() {
        return ResultGenerator.successResult(orderService.getHotProducts());
    }

}

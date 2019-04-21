package com.zhongwen.shopping.controller;

import com.zhongwen.shopping.service.IProductTypeService;
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
 * @data 2019-03-24 10:11
 **/
@Controller
@ResponseBody
@RequestMapping(value = "/productType")
public class ProductTypeController {

    @Autowired
    IProductTypeService productTypeService;

    @RequestMapping(value = "/getAllType", method = RequestMethod.POST)
    public ResultVO getAllType() {
        return ResultGenerator.successResult(productTypeService.getAllType());
    }

    /**
     * 获取商品一级分类
     * @return
     */
    @RequestMapping(value = "/getPrimaryClassification", method = RequestMethod.GET)
    public ResultVO getPrimaryClassification() {
        return null;
    }

}

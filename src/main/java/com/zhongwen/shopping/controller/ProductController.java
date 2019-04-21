package com.zhongwen.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.bean.ProductInfoBean;
import com.zhongwen.shopping.service.IProductInfoService;
import com.zhongwen.shopping.util.ResultGenerator;
import com.zhongwen.shopping.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-24 00:35
 **/
@Controller
@ResponseBody
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    IProductInfoService productInfoService;

    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public ResultVO getProductInfoById(@RequestBody JSONObject prams) {
        Integer id = prams.getInteger("id");
        return ResultGenerator.successResult(productInfoService.getProductById(id));
    }

    @RequestMapping(value = "/getProductList", method = RequestMethod.POST)
    public ResultVO getProductList(@RequestBody JSONObject prams) {
        ProductInfoBean productInfoBean = new ProductInfoBean();
        productInfoBean.setIndexDetailId(prams.getInteger("typeId"));
        productInfoBean.setOffset(prams.getInteger("offset"));
        productInfoBean.setLimit(prams.getInteger("limit"));
        productInfoBean.setOrder(prams.getString("order"));
        return ResultGenerator.successResult(productInfoService.getProductInfoByTypeId(productInfoBean));
    }

    @RequestMapping(value = "/getProductListV1", method = RequestMethod.POST)
    public ResultVO getProductListV1(@RequestBody JSONObject prams) {
        ProductInfoBean productInfoBean = new ProductInfoBean();
        productInfoBean.setIndexDetailId(prams.getInteger("typeId"));
        productInfoBean.setOffset(prams.getInteger("offset"));
        productInfoBean.setLimit(prams.getInteger("limit"));
        productInfoBean.setOrder(prams.getString("order"));
        return ResultGenerator.successResult(productInfoService.getProductFullInfoByIndexDetailId(productInfoBean));
    }
}

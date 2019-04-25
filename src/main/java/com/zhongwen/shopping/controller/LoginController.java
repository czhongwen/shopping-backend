package com.zhongwen.shopping.controller;

import com.zhongwen.shopping.service.impl.LoginServiceImpl;
import com.zhongwen.shopping.util.ResultGenerator;
import com.zhongwen.shopping.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-23 23:18
 **/
@Controller
@ResponseBody
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @RequestMapping(value = "/getOpenId", method = RequestMethod.POST)
    public ResultVO getOpenId(@RequestBody String key) {
        return ResultGenerator.successResult(loginService.getOpenId(key));
    }

}

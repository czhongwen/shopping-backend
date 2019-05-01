package com.zhongwen.shopping.controller;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-05-01 16:23
 **/

import com.zhongwen.shopping.edit.ueditor.ActionEnter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 用于处理关于ueditor插件相关的请求
 * @author Guoqing
 * @date 2017-11-29
 *
 */
@RestController
@CrossOrigin(origins = "https://www.czhongwen.xyz:80")
@RequestMapping("/ueditor")
public class UeditorController {

    @RequestMapping(value = "/exec")
    @ResponseBody
    public String exec(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String rootPath = request.getRealPath("/");
        response.setHeader("Access-Control-Allow-Origin", "https://www.czhongwen.xyz:80");
        return new ActionEnter( request, rootPath ).exec();
    }

}

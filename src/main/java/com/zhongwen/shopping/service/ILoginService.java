package com.zhongwen.shopping.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-23 22:57
 **/
@Transactional
public interface ILoginService {

    /**
     * 获取用户openID
     * @return
     */
    Map<String, String> getOpenId(String key);

}

package com.zhongwen.shopping.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
/**
 * @author caozw
 * @version 1.0
 * @data 2019-05-04 21:38
 **/
@Service
public class HttpClient {

//    public String client(String url, HttpMethod method, MultiValueMap<String, String> prams) {
//
//        RestTemplate template = new RestTemplate();
//        ResponseEntity<String> res = template.getForEntity(url, String.class);
//        return res.toString();
//    }

    public String client(String url, HttpMethod method, MultiValueMap<String, String> params){
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //  执行HTTP请求
        ResponseEntity<String> response = client.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }
}

package com.zhongwen.shopping.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.service.ILoginService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-23 22:58
 **/

@Service
public class LoginServiceImpl implements ILoginService {
    @Override
    public Map<String, String> getOpenId(String key) throws Exception{
        if (key == null ) {
            throw new Exception("sorry,未获得您的key,请检查网络。");
        }

        JSONObject object = JSON.parseObject(key);

        String[] strings = load(object.getString("key"));

        if (strings == null || strings.length != 2 || strings[1] == null) {
            throw new Exception("sorry,未获取到OpenId");
        }
        Map<String, String> map = new HashMap<>();
        map.put("openid", strings[1]);
        return map;
    }

    private String[] load(String key) throws Exception
    {
        URL restURL = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=wxcbe2035fdc5f64a7&secret=b9b3d9ed83141616af06f3c8b5a25c6e&grant_type=authorization_code&js_code=" + key);
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        conn.setAllowUserInteraction(false);
        PrintStream ps = new PrintStream(conn.getOutputStream());
        ps.print("floor=first&year=2017&month=9&isLeader=N");
        ps.close();
        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line,resultStr="";
        while(null != (line=bReader.readLine())){
            resultStr +=line;
        }
        JSONObject res=JSONObject.parseObject(resultStr);
        String session_key=res.getString("session_key");
        String openid=res.getString("openid");
        bReader.close();
        String[] result=new String[2];
        result[0]=session_key;
        result[1]=openid;
        return result;
    }
}

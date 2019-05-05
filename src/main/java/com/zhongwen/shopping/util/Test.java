package com.zhongwen.shopping.util;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


/**
 * @author caozw
 * @version 1.0
 * @data 2019-05-05 11:05
 **/
public class Test {

    public static void main(String[] args) {
        Multimap<String, String> map = ArrayListMultimap.create();
        map.put("中文", "加油");
        map.put("中文", "加油哇");
        System.out.println(map.size());

        for (String key : map.keySet()) {
            System.out.println("key: " + key + ";value:" + map.get(key));
            System.out.println("进来了");
            System.out.println(map.get(key).size());
            map.remove(key,"加油");
        }
        System.out.println(map.size());

        for (String key : map.keySet()) {
            System.out.println("key: " + key + ";value:" + map.get(key));
        }
    }


}

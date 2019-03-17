package com.zhongwen.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhongwen.shopping.dao")
public class ShoppingApplication {

    public static void main(String[] args) {
        System.out.println("==========项目开始启动==========");
        SpringApplication.run(ShoppingApplication.class, args);
        System.out.println("==========项目启动成功==========");
    }

}

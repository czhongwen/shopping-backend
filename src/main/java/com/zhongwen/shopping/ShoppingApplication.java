package com.zhongwen.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.zhongwen.shopping.dao")
public class ShoppingApplication {

    public static void main(String[] args) {
        System.out.println("==========项目开始启动==========");
        SpringApplication.run(ShoppingApplication.class, args);
        System.out.println("==========项目启动成功==========");
    }

    //spring boot 跨域问题
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/*").allowedOrigins("http://localhost:8080");
//            }
//        };
//    }
}

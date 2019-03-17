package com.zhongwen.shopping;

import com.zhongwen.shopping.dao.ICartInfoDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 10:34
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartInfoDAOTest {

    @Autowired
    ICartInfoDAO cartInfoDAO;

    @Test
    public void getCartInfos() {
        System.out.println("开始");
        System.out.println(cartInfoDAO.getCartsList("o_k4M5CkHNYRH2M7zIBHqYcqxlU4"));
        System.out.println("结束");
    }

}
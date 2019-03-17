package com.zhongwen.shopping;

import com.zhongwen.shopping.dao.IOrderInfoDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 20:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderInfoTest {

    @Autowired
    IOrderInfoDAO orderInfoDAO;

    @Test
    public void addTest() {
        System.out.println(orderInfoDAO.getOrderInfoList("o_k4M5CkHNYRH2M7zIBHqYcqxlU4"));
    }

}

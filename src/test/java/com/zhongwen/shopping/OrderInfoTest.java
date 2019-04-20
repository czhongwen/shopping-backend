package com.zhongwen.shopping;

import com.zhongwen.shopping.bean.OrderInfoBean;
import com.zhongwen.shopping.dao.IOrderInfoDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

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

    @Test
    public void add(){
        OrderInfoBean orderInfoBean = new OrderInfoBean();
        orderInfoBean.setStatus("待发货");
        orderInfoBean.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
        orderInfoBean.setAddressId(1);
        orderInfoBean.setOpenId("o_k4M5CkHNYRH2M7zIBHqYcqxlU4");
        System.out.println(orderInfoDAO.addOrderInfo(orderInfoBean));
        System.out.println(orderInfoBean.getId());
    }
}

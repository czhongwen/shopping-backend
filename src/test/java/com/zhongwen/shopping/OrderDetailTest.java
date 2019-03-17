package com.zhongwen.shopping;

import com.zhongwen.shopping.bean.OrderDetailBean;
import com.zhongwen.shopping.dao.IOrderDetailDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 21:29
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailTest {

    @Autowired
    IOrderDetailDAO orderDetailDAO;

    @Test
    public void addListTest() {
        List<OrderDetailBean> orderDetailBeanList = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            OrderDetailBean orderDetailBean = new OrderDetailBean();
            orderDetailBean.setOrderId(342339);
            orderDetailBean.setProductId(88);
            orderDetailBean.setProductNum(100);
            orderDetailBeanList.add(orderDetailBean);
        }

        System.out.println(orderDetailDAO.addOrderDetail(orderDetailBeanList));
    }

    @Test
    public void getList(){
        System.out.println(orderDetailDAO.getOrderDetailList(342340));
    }
}

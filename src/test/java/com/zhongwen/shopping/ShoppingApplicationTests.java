package com.zhongwen.shopping;

import com.zhongwen.shopping.bean.AddressInfoBean;
import com.zhongwen.shopping.dao.IAddressInfoDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.jvm.hotspot.debugger.Address;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingApplicationTests {

    @Autowired
    IAddressInfoDAO addressInfoDAO;
    @Test
    public void contextLoads() {
        System.out.println("开始");
        System.out.println(addressInfoDAO.getListAddInfoByOpenId("o_k4M5CkHNYRH2M7zIBHqYcqxlU4"));
        System.out.println("结束");
    }

    @Test
    public void updateAddressInfo() {

        System.out.println("开始");

        List<AddressInfoBean> addressInfoBeanList = addressInfoDAO.getListAddInfoByOpenId("o_k4M5CkHNYRH2M7zIBHqYcqxlU4");
        System.out.println("查询的用户的收获地址数量: " + addressInfoBeanList.size());
        AddressInfoBean addressInfoBean = addressInfoBeanList.get(0);
        System.out.println(addressInfoBeanList.get(0).toString());
        addressInfoBean.setDetail("花园路105号");
        System.out.println(addressInfoDAO.updateAddressInfo(addressInfoBean));
        System.out.println(addressInfoDAO.getListAddInfoByOpenId("o_k4M5CkHNYRH2M7zIBHqYcqxlU4").get(0).toString());
        System.out.println("结束！！！！");
    }

}

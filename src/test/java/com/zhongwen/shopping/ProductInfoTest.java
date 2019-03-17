package com.zhongwen.shopping;

import com.zhongwen.shopping.bean.ProductInfoBean;
import com.zhongwen.shopping.dao.IProductInfoDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 17:29
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoTest {

    @Autowired
    IProductInfoDAO productInfoDAO;

    @Test
    public void getProductNumTest() {
        System.out.println(productInfoDAO.getProductNum(110));
    }

    @Test
    public void getProductInfoByIdTest() {
        ProductInfoBean productInfoBean = new ProductInfoBean();
        productInfoBean.setIndexDetailId(1);
        System.out.println(productInfoDAO.getProductCount(productInfoBean));
    }

}

package com.zhongwen.shopping;

import com.zhongwen.shopping.bean.IndexDeailBean;
import com.zhongwen.shopping.dao.IIndexDetailDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 15:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexDetailTest {

    @Autowired
    IIndexDetailDAO iIndexDetailDAO;

    @Test
    public void addIndexDetailTest() {
        IndexDeailBean indexDeailBean = new IndexDeailBean();
        indexDeailBean.setId(1);
        indexDeailBean.setImageUrl("520");
        indexDeailBean.setName("520");
        System.out.println(iIndexDetailDAO.addIndexDetail(indexDeailBean));
    }

    @Test
    public void getListIndexDetil() {
        System.out.println(iIndexDetailDAO.getIndexDetail(2));
    }

    @Test
    public void updateindexDetailTest() {
        IndexDeailBean indexDeailBean = new IndexDeailBean();
        indexDeailBean.setName("110");
        indexDeailBean.setImageUrl("110");
        indexDeailBean.setIndexTypeId(2);
        indexDeailBean.setId(92);
        System.out.println(iIndexDetailDAO.updateIndexDetail(indexDeailBean));
    }

    @Test
    public void deleteIndexdetail() {
        System.out.println(iIndexDetailDAO.deleteIndexDetailById(92));
    }
}

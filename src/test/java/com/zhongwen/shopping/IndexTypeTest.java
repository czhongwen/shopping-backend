package com.zhongwen.shopping;

import com.zhongwen.shopping.bean.IndexTypeBean;
import com.zhongwen.shopping.dao.IIndexTypeDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 14:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexTypeTest {

    @Autowired
    IIndexTypeDAO indexTypeDAO;

    @Test
    public void testGetList() {
        System.out.println(indexTypeDAO.getIndexTypeList());
    }

    @Test
    public void testAdd() {
        IndexTypeBean indexTypeBean = new IndexTypeBean();
        indexTypeBean.setImageUrl("520");
        indexTypeBean.setName("双十一爆款");
        System.out.println(indexTypeDAO.addIndexType(indexTypeBean));
    }

    @Test
    public void deleteTest() {
        System.out.println(indexTypeDAO.deleteIndexTypeById(14));
    }

    @Test
    public void updateIndexTypeTest() {
        IndexTypeBean indexTypeBean = new IndexTypeBean();
        indexTypeBean.setId(14);
        indexTypeBean.setName("520");
        indexTypeBean.setImageUrl("520");
        System.out.println(indexTypeDAO.updateIndexTypeById(indexTypeBean));
    }
}

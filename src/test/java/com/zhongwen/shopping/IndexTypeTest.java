package com.zhongwen.shopping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.bean.IndexTypeBean;
import com.zhongwen.shopping.dao.IIndexTypeDAO;
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

    @Test
    public void getAll() {
        List<IndexTypeBean> indexTypeBeans = indexTypeDAO.getIndexTypeList();
        for (IndexTypeBean indexTypeBean : indexTypeBeans) {
            String imageUrl = indexTypeBean.getImageUrl();
            indexTypeBean.setImageUrl(imageUrl.replace("/wxshopping/userfiles",""));
        }
        System.out.println(indexTypeBeans);
        System.out.println(indexTypeDAO.updateIndexTypeById(indexTypeBeans.get(0)));
        System.out.println("修改完成！！！");
    }

    @Test
    public void test(){
        String arr = "[\"1.0.0\",\"2.0.0\"]";

        System.out.println(JSONArray.parseArray(arr));

        String json = "[{\n" +
                "        \"languageContent\": \"qqqqq\",\n" +
                "        \"languageType\":\"zh\",\n" +
                "        \"languageTitle\": \"qqqq\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"languageContent\": \"2222\",\n" +
                "        \"languageType\": \"en\",\n" +
                "        \"languageTitle\": \"2222\"\n" +
                "    }\n" +
                "]";

        JSONObject jsonObject = new JSONObject();
        parseJsonBody(JSONArray.parseArray(json), "ios", "ios", jsonObject);
        System.out.println(jsonObject);
    }


    private boolean parseJsonBody(JSONArray langRemind, String url, String client, JSONObject jsonBody){


        List<JSONObject> msgs = new ArrayList<>();

        for (Object json1: langRemind) {
            System.out.println(json1);
            JSONObject json = (JSONObject) json1;


            JSONObject msg = new JSONObject();
            msg.put("languageType", json.getString("languageType"));
            msg.put("languageContent", json.getString("languageContent"));
            msg.put("languageTitle", json.getString("languageTitle"));
            msgs.add(msg);


            //msgs.add(json);
        }

        jsonBody.put("url", url);
        jsonBody.put("multiLanguage", msgs);
        //android客户端需配置md5标签
        return true;
    }
}

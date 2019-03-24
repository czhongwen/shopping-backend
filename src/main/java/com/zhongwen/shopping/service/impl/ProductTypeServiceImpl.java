package com.zhongwen.shopping.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.bean.IndexDeailBean;
import com.zhongwen.shopping.bean.IndexTypeBean;
import com.zhongwen.shopping.dao.IIndexDetailDAO;
import com.zhongwen.shopping.dao.IIndexTypeDAO;
import com.zhongwen.shopping.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-24 10:21
 **/
@Service
public class ProductTypeServiceImpl implements IProductTypeService {

    @Autowired
    IIndexTypeDAO indexTypeDAO;
    @Autowired
    IIndexDetailDAO indexDetailDAO;

    @Override
    public JSONArray getAllType() throws Exception {
        List<IndexTypeBean> indexTypeBeans =  indexTypeDAO.getIndexTypeList();

        if (indexTypeBeans == null || indexTypeBeans.size() <= 0) {
            throw new Exception("sorry,系统异常");
        }

        List<Integer> typeIds = new ArrayList<>();
        for (IndexTypeBean indexBean:indexTypeBeans) {
            typeIds.add(indexBean.getId());
        }

        List<IndexDeailBean> indexDetailBeans = indexDetailDAO.getIndexDetailByIds(typeIds);

        if (indexDetailBeans == null || indexDetailBeans.size() <= 0) {
            throw new Exception("sorry,系统异常");
        }

        //封装查询的结果
        JSONArray result = new JSONArray();
        for (IndexTypeBean indexBean:indexTypeBeans) {
            JSONObject object = new JSONObject();

            object.put("typeId", indexBean.getId());
            object.put("typename", indexBean.getName());
            object.put("typeImage", indexBean.getImageUrl());

            JSONArray array = new JSONArray();
            for (IndexDeailBean indexDeailBean : indexDetailBeans) {
                if (indexBean.getId().equals(indexDeailBean.getIndexTypeId())) {
                    array.add(indexDeailBean);
                }
            }
            object.put("detail", array);
            result.add(object);
        }

        return result;
    }
}

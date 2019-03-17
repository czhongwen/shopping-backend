package com.zhongwen.shopping.dao;

import com.zhongwen.shopping.bean.IndexTypeBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 13:58
 **/

@Service
public interface IIndexTypeDAO {

    /**
     * 获得全部大分类
     * @return
     */
    List<IndexTypeBean> getIndexTypeList();

    /**
     * 添加大分类
     * @param indexTypeBean
     * @return
     */
    int addIndexType(IndexTypeBean indexTypeBean);

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    int deleteIndexTypeById(Integer id);

    /**
     * 根据id修改分类
     * @param indexTypeBean
     * @return
     */
    int updateIndexTypeById(IndexTypeBean indexTypeBean);
}

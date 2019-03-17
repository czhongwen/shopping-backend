package com.zhongwen.shopping.dao;

import com.zhongwen.shopping.bean.IndexDeailBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 14:38
 **/
@Service
public interface IIndexDetailDAO {
    /**
     * 添加分类（小分类）
     * @param indexDeailBean
     * @return
     */
    int addIndexDetail(IndexDeailBean indexDeailBean);

    /**
     * 根据ID删除小分类
     * @param id
     * @return
     */
    int deleteIndexDetailById(Integer id);

    /**
     * 修改小分类信息
     * @param indexDeailBean
     * @return
     */
    int updateIndexDetail(IndexDeailBean indexDeailBean);

    /**
     * 根据大分类的ID获得小分类的列表
     * @param indextypeId
     * @return
     */
    List<IndexDeailBean> getIndexDetail(Integer indextypeId);
}

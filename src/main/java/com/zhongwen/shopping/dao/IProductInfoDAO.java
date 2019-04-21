package com.zhongwen.shopping.dao;

import com.zhongwen.shopping.bean.ProductInfoBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 15:41
 **/
@Service
public interface IProductInfoDAO {

    /**
     * 增加商品信息
     * @param productInfoBean
     * @return
     */
    int addProductInfo(ProductInfoBean productInfoBean);

    /**
     * 修改信息
     */
    int updateProductInfo(ProductInfoBean productInfoBean);

    /**
     * 根据ID获得商品详情信息
     * @param id
     * @return
     */
    ProductInfoBean getProductInfoById(Integer id);

    /**
     * 根据类型id查询商品（分页）【信息不完整，仅提供给前台】
     * @param productInfoBean
     * @return
     */
    List<ProductInfoBean> getProductInfoByIndexDetailId(ProductInfoBean productInfoBean);

    /**
     * 根据类型id查询商品（分页）【信息完整，提供给后台】
     * @param productInfoBean
     * @return
     */
    List<ProductInfoBean> getProductFullInfoByIndexDetailId(ProductInfoBean productInfoBean);

    /**
     * 获得某一个类型的总商品数量
     * @param productInfoBean
     * @return
     */
    int getProductCount(ProductInfoBean productInfoBean);

    /**
     * 查询某一件商品的剩余数量
     * @param id
     * @return
     */
    int getProductNum(Integer id);

    /**
     * 修改商品的剩余数量
     * @param id
     * @return
     */
    int updateProductNum(Integer id);

    /**
     * 批量查询商品详情
     * @param ids
     * @return
     */
    List<ProductInfoBean> getProducts(List<Integer> ids);
}

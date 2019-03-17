package com.zhongwen.shopping.dao;

import com.zhongwen.shopping.bean.CartInfoBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 09:20
 **/
@Service
public interface ICartInfoDAO {

    /**
     * 修改购物车信息
     * @param cartInfoBean
     * @return
     */
    int updateCartInfo(CartInfoBean cartInfoBean);

    /**
     * 根据openID查询购物车
     * @param openId
     * @return
     */
    List<CartInfoBean> getCartsList(String openId);

    /**
     * 根据ID删除购物车
     * @param cartId
     * @return
     */
    int deleteCartId(Integer cartId);

    /**
     * 增加购物车
     * @param cartInfoBean
     * @return
     */
    int addCarts(CartInfoBean cartInfoBean);
}

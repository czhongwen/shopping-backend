package com.zhongwen.shopping.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhongwen.shopping.bean.OrderDetailBean;
import com.zhongwen.shopping.bean.OrderInfoBean;
import com.zhongwen.shopping.bean.ProductInfoBean;
import com.zhongwen.shopping.dao.ICartInfoDAO;
import com.zhongwen.shopping.dao.IOrderDetailDAO;
import com.zhongwen.shopping.dao.IOrderInfoDAO;
import com.zhongwen.shopping.dao.IProductInfoDAO;
import com.zhongwen.shopping.service.HttpClient;
import com.zhongwen.shopping.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-19 00:06
 **/
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDetailDAO orderDetailDAO;
    @Autowired
    private IProductInfoDAO productInfoDAO;
    @Autowired
    private IOrderInfoDAO orderInfoDAO;
    @Autowired
    private ICartInfoDAO cartInfoDAO;
    @Autowired
    private HttpClient httpClient;

    @Override
    public List<ProductInfoBean> getHotProducts() {

        List<Integer> productIds = orderDetailDAO.getHotProduct();

        List<ProductInfoBean> productInfoBeans = productInfoDAO.getProducts(productIds);

        return productInfoBeans;
    }

    @Override
    public List<Map> getOrdersByOpenId(String openId) {
        if (openId == null ) {
            throw new RuntimeException("参数异常!");
        }

        List<OrderInfoBean> orderInfoBeans = orderInfoDAO.getOrderInfoList(openId);

        if (CollectionUtils.isEmpty(orderInfoBeans)) {
            return new ArrayList<>();
        }

        List<Integer> orderIds = new ArrayList<>();

        List<Map> orderInfos = new ArrayList<>();
        for (OrderInfoBean orderInfoBean : orderInfoBeans) {
            orderIds.add(orderInfoBean.getId());
            Map orderInfoMap = new HashMap();
            orderInfoMap.put("orderId", orderInfoBean.getId());
            orderInfoMap.put("addressId", orderInfoBean.getAddressId());
            orderInfoMap.put("time", orderInfoBean.getDate());
            orderInfoMap.put("status", orderInfoBean.getStatus());
            orderInfoMap.put("list", new ArrayList<Map>());
            orderInfos.add(orderInfoMap);
        }

        List<OrderDetailBean> orderDetailBeans = orderDetailDAO.getByIds(orderIds);

        if (CollectionUtils.isEmpty(orderDetailBeans)) {
            return new ArrayList<>();
        }

        List<Integer> productIds = new ArrayList<>();
        Map orderDetailMap = new HashMap();
        for (OrderDetailBean orderDetailBean : orderDetailBeans) {
            productIds.add(orderDetailBean.getProductId());
            orderDetailMap.put(orderDetailBean.getOrderId(), orderDetailBean.getProductNum());
            orderDetailMap.put(orderDetailBean.getProductId(), orderDetailBean.getOrderId());
        }

        List<ProductInfoBean> productInfoBeans = productInfoDAO.getProducts(productIds);

        if (CollectionUtils.isEmpty(productInfoBeans)) {
            return new ArrayList<>();
        }

        List<Map> orderDetails = new ArrayList<>();
        for (ProductInfoBean productInfoBean : productInfoBeans) {
            Map temp = new HashMap();
            temp.put("image", productInfoBean.getImage1());
            temp.put("name", productInfoBean.getName());
            temp.put("info", productInfoBean.getInfo());
            temp.put("num", orderDetailMap.get(orderDetailMap.get(productInfoBean.getId())));
            temp.put("orderId", orderDetailMap.get(productInfoBean.getId()));
            temp.put("detail", productInfoBean.getDetail());
            orderDetails.add(temp);
        }

        for (Map orderInfoMap : orderInfos) {
            for (Map orderDetailMaps : orderDetails) {
                if ( orderInfoMap.get("orderId").equals(orderDetailMaps.get("orderId")) ) {
                    List<Map> map = (ArrayList<Map>)orderInfoMap.get("list");
                    orderDetailMaps.put("status", orderInfoMap.get("status"));
                    map.add(orderDetailMaps);
                    orderInfoMap.put("list", map);
                }
            }
        }

        return orderInfos;
    }

    @Override
    public synchronized Boolean addOrders(JSONObject prams) {

        String openId = prams.getString("openId");
        Integer addressId = prams.getInteger("addressId");
        JSONArray orders = prams.getJSONArray("list");
        JSONArray cartIds = prams.getJSONArray("cartIds");
        String formId = prams.getString("formId");


        if (StringUtils.isEmpty(openId)) {
            throw new RuntimeException("参数错误!");
        }

        if (addressId <= 0) {
            throw new RuntimeException("收货地址有误!");
        }

        if (CollectionUtils.isEmpty(orders)) {
            throw new RuntimeException("未选择任何商品!");
        }

        Map<Integer, Integer> map = new HashMap();
        List<Integer> productIds = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            JSONObject obj = orders.getJSONObject(i);
            map.put(obj.getInteger("productId"), obj.getInteger("num"));
            productIds.add(obj.getInteger("productId"));
        }

        //查询出商品数量
        List<ProductInfoBean> productInfoBeans = productInfoDAO.getProducts(productIds);

        //判断库存是否满足用户购买
        for (ProductInfoBean productInfo: productInfoBeans) {
            if (productInfo.getNum() < map.get(productInfo.getId())) {
                throw new RuntimeException("对不起！您所购买的" + productInfo.getName() + "库存不足，仅剩下" + productInfo.getNum() + "件");
            } if (productInfo.getStatus() == 0) {
                throw new RuntimeException("对不起！您购买的" + productInfo.getName() + "已下架！");
            }
        }

        //先插入订单表拿到返回的orderID
        OrderInfoBean orderInfoBean = new OrderInfoBean();
        orderInfoBean.setAddressId(addressId);
        orderInfoBean.setDate(new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss").format(System.currentTimeMillis()));
        orderInfoBean.setStatus("待发货");
        orderInfoBean.setOpenId(openId);
        orderInfoDAO.addOrderInfo(orderInfoBean);
        Integer orderId = orderInfoBean.getId();

        //插入订单详情表
        List<OrderDetailBean> orderDetailBeans = new ArrayList<>();
        for (Integer key: map.keySet()) {
            OrderDetailBean orderDetailBean = new OrderDetailBean();
            orderDetailBean.setProductNum(map.get(key));
            orderDetailBean.setProductId(key);
            orderDetailBean.setOrderId(orderId);
            orderDetailBeans.add(orderDetailBean);
        }
        orderDetailDAO.addOrderDetail(orderDetailBeans);

        //修改库存数量
        for (ProductInfoBean productInfo: productInfoBeans) {
            ProductInfoBean productInfoBean = new ProductInfoBean();
            productInfoBean.setNum(productInfo.getNum() - map.get(productInfo.getId()));
            productInfoBean.setId(productInfo.getId());
            productInfoDAO.updateProductInfo(productInfoBean);
        }

        //删除购物车
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < cartIds.size(); i++) {
            ids.add(cartIds.getInteger(i));
        }
        cartInfoDAO.delCartsByIds(ids);
        //发送模版信息
        this.sendTemplatePaySuccess(openId,formId,orderId);
        return true;
    }

    private String getAccessToken(){
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxcbe2035fdc5f64a7&secret=5c9d17e13b98c074e9bf4ae474676dfe";
        Map<String, Object> prams = new HashMap<>();
        prams.put("grant_type", "client_credential");
        prams.put("appid", "wxcbe2035fdc5f64a7");
        prams.put("secret","5c9d17e13b98c074e9bf4ae474676dfe");

        String res = httpClient.client(url, HttpMethod.GET, prams);

        res = res.substring(res.indexOf('{'), res.indexOf('}')+1);
        JSONObject obj = JSONObject.parseObject(res);
        return obj.getString("access_token");
    }

    public void sendTemplatePaySuccess(String openId, String formId,Integer orderId){
        String token = this.getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + token;

        Map<String, Object> prams = new HashMap<>();
        prams.put("touser", openId );
        prams.put("template_id", "vdknVhzNHj5n0esLDs_EzAw3H2xnBkT_X7jcFJmYgBM");
        prams.put("form_id", formId );
        prams.put("page", "myOrders");

        JSONObject obj = new JSONObject();

        JSONObject obj1 = new JSONObject();
        obj1.put("value", orderId);
        obj.put("keyword1", obj1);

        JSONObject obj2 = new JSONObject();
        obj2.put("value", new SimpleDateFormat("yyyy年mm月dd日 HH时mm分ss秒").format(System.currentTimeMillis()));
        obj.put("keyword2", obj2);

        JSONObject obj3 = new JSONObject();
        obj3.put("value", "1000元");
        obj.put("keyword3", obj3);

        prams.put("data", obj);

        String rs = httpClient.client(url, HttpMethod.POST, prams);

    }
}

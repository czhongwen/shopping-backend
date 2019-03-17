package com.zhongwen.shopping.bean;

import com.zhongwen.shopping.bean.common.BasicBean;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 15:25
 **/
public class ProductInfoBean extends BasicBean {

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品信息
     */
    private String Info;

    /**
     * 所属的小分类的id
     */
    private Integer IndexDetailId;

    /**
     * 添加时间
     */
    private String date;

    /**
     * 详情描述（富文本编辑）
     */
    private String detail;

    /**
     * 是否在首页
     */
    private Integer index;

    /**
     * 轮播图
     */
    private String image1;

    /**
     * 轮播图
     */
    private String image2;

    /**
     * 轮播图
     */
    private String image3;

    /**
     * 轮播图
     */
    private String image4;

    /**
     * 轮播图
     */
    private String image5;

    /**
     * 商品颜色
     */
    private String color;

    /**
     * 分类
     */
    private String tupical;

    /**
     * 商品价格
     */
    private Integer price;

    /**
     * 商品的数量
     */
    private Integer num;

    /**
     * 商品的打折信息
     */
    private Integer descount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public Integer getIndexDetailId() {
        return IndexDetailId;
    }

    public void setIndexDetailId(Integer indexDetailId) {
        IndexDetailId = indexDetailId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTupical() {
        return tupical;
    }

    public void setTupical(String tupical) {
        this.tupical = tupical;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDescount() {
        return descount;
    }

    public void setDescount(Integer descount) {
        this.descount = descount;
    }

    @Override
    public String toString() {
        return "ProductInfoDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Info='" + Info + '\'' +
                ", IndexDetailId=" + IndexDetailId +
                ", date='" + date + '\'' +
                ", detail='" + detail + '\'' +
                ", index=" + index +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                ", image4='" + image4 + '\'' +
                ", image5='" + image5 + '\'' +
                ", color='" + color + '\'' +
                ", tupical='" + tupical + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", descount=" + descount +
                '}';
    }
}

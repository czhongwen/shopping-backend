package com.zhongwen.shopping.bean;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 13:20
 **/
public class IndexTypeBean {

    /**
     * 大类型ID
     */
    private Integer id;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 类型名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IndexTypeBean{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.zhongwen.shopping.bean;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 14:32
 **/
public class IndexDeailBean {

    /**
     * 小分类id
     */
    private Integer id;

    /**
     * 大分类的Id
     */
    private Integer indexTypeId;

    /**
     * 小分类名称
     */
    private String name;

    /**
     * 图片地址
     */
    private String imageUrl;

    public IndexDeailBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndexTypeId() {
        return indexTypeId;
    }

    public void setIndexTypeId(Integer indexTypeId) {
        this.indexTypeId = indexTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "IndexDeailBean{" +
                "id=" + id +
                ", indexTypeId=" + indexTypeId +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

package com.zhongwen.shopping.bean.common;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-17 16:05
 **/
public class BasicBean {

    /**
     * 偏移量
     */
    private Integer offset;

    /**
     * 数量
     */
    private Integer limit;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "BasicBean{" +
                "offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}

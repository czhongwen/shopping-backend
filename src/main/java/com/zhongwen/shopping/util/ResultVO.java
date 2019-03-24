package com.zhongwen.shopping.util;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-23 22:58
 **/
public class ResultVO {
    /**
     * 返回编码
     */
    private String code;
    /**
     * 消息提示信息
     */
    private String msg;
    /**
     * 状态信息
     */
    private boolean flag;
    /**
     * 返回结果
     */
    private Object result;
    /**
     * 返回结果总数
     */
    private int rows;
    /**
     * 需要返回的路径
     */
    private String backendUrl;
    /**
     * 相应异常
     */
    private Throwable throwable;

    private ResultVO(){

    }

    /**
     * 统一处理
     * @return
     */
    public static ResultVO newInstance(){
        return  new ResultVO();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getBackendUrl() {
        return backendUrl;
    }

    public void setBackendUrl(String backendUrl) {
        this.backendUrl = backendUrl;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

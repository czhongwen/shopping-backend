package com.zhongwen.shopping.util;


import java.util.Collection;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-03-23 22:57
 **/
public final class ResultGenerator {

    // 执行成功code
    public static String successCode = "100";
    // 执行失败code
    public static String errorCode = "101";
    // 自定义原因执行失败code
    public static String customErrorCode = "102";

    /**
     * 统一处理
     * @param code
     * @param msg
     * @param flag
     * @param result
     * @param rows
     * @param backendUrl
     * @param throwable
     * @return
     */
    public static ResultVO  result(String code,String msg,boolean flag,Object result,int rows,String backendUrl,Throwable throwable){
        ResultVO vo=ResultVO.newInstance();
        vo.setCode(code);
        vo.setMsg(msg);
        vo.setFlag(flag);
        vo.setResult(result);
        vo.setRows(rows);
        vo.setBackendUrl(backendUrl);
        //vo.setThrowable(throwable);
        return vo;
    }

    /**
     * 执行成功方法
     * @param result 规定code为100代表执行成功
     * @return
     */
     public static ResultVO  successResult(Object result){
        //默认是零
        int rows=0;
        if(result instanceof Collection){
            rows=((Collection) result).size();
        }
        return result(successCode,"执行成功",true, result,rows,"",null);
     }

    /**
     * code 为101代表执行失败
     * @param msg
     * @param throwable
     * @return
     */
     public static ResultVO failResult(String msg,Throwable throwable){
        return result(errorCode,msg,false,null,0,"",throwable);
     }

    /**
     * code 为102代表执行失败, 并且抛出自定义错误原因， 101 同时会把其他runtime异常抛出，前端不能自定义提示语
     * @param msg
     * @return
     */
    public static ResultVO failCustomResult(String msg){
        return result(customErrorCode,msg,false,null,0,"",null);
    }

    /**
     * 判断当前resultVO是不是成功ResultVO
     *
     * @param resultVO
     * @return
     */
    public static boolean isSuccess(ResultVO resultVO) {
        if (successCode.equals(resultVO.getCode())) {
            return true;
        }
        return false;
    }


    /**
     * 判断当前resultVO是不是失败ResultVO
     *
     * @param resultVO
     * @return
     */
    public static boolean isFail(ResultVO resultVO) {
        return !isSuccess(resultVO);
    }
}

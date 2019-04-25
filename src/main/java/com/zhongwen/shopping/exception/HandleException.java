package com.zhongwen.shopping.exception;

import com.zhongwen.shopping.util.ResultGenerator;
import com.zhongwen.shopping.util.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author caozw
 * @version 1.0
 * @data 2019-04-03 17:41
 **/
@ControllerAdvice
public class HandleException {

    private final static Logger logger  = LoggerFactory.getLogger(HandleException.class);

    @ExceptionHandler(RuntimeException.class)
    public ResultVO runtimeExceptionHandler(RuntimeException ex) {
        logger.info("运行异常 {}", ex);
        System.out.println("异常了");
        return ResultGenerator.failResult(ex.getMessage(), ex.getCause());
    }
}

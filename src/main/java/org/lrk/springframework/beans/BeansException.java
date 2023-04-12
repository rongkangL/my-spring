package org.lrk.springframework.beans;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 7:51
 * @Description: Bean异常
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}

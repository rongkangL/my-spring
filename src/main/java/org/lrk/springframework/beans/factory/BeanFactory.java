package org.lrk.springframework.beans.factory;

import org.lrk.springframework.beans.BeansException;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 7:51
 * @Description: Bean异常
 */
public interface BeanFactory {

    /**
     * 返回 Bean 的实例对象（无参）
     * @param name 要检索的bean的名称
     * @return 实例化的 Bean 对象
     * @throws BeansException 不能获取 Bean 对象，则抛出异常
     */
    Object getBean(String name) throws BeansException;

    /**
     * 返回 Bean 的实例对象（有参）
     * @param name 要检索的Bean的名字
     * @param args 构建Bean所用的参数
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

}

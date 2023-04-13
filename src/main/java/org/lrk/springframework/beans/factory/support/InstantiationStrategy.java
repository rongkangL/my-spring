package org.lrk.springframework.beans.factory.support;

import org.lrk.springframework.beans.BeansException;
import org.lrk.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: lrk
 * @Date: 2023/4/13 上午 9:50
 * @Description: 定义实例化策略接口
 */
public interface InstantiationStrategy {

    /**
     * 实例化Bean
     * @param beanDefinition Bean的定义
     * @param beanName Bean的名字
     * @param ctor 一些必须的类的信息
     * @param args 构造Bean的构造参数
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}

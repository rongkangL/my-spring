package org.lrk.springframework.beans.factory.support;

import org.lrk.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 9:51
 * @Description: Bean 定义注册接口
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}

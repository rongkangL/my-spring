package org.lrk.springframework.beans.factory.support;

import org.lrk.springframework.beans.BeansException;
import org.lrk.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 7:59
 * @Description:
 */
public abstract class AbstractAutowireCapableBeanFactory  extends AbstractBeanFactory{

    /**
     * 创造Bean
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("创建Bean失败", e);
        }
        // 将Bean注册为单例
        registerSingleton(beanName, bean);
        return bean;
    }
}

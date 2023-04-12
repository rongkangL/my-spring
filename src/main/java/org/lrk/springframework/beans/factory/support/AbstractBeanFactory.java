package org.lrk.springframework.beans.factory.support;

import org.lrk.springframework.beans.BeansException;
import org.lrk.springframework.beans.factory.BeanFactory;
import org.lrk.springframework.beans.factory.config.BeanDefinition;
import org.lrk.springframework.beans.factory.config.DefaultSingletonBeanRegistry;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 7:48
 * @Description:
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    /**
     * 获取Bean实例
     * 无法获取Bean对象时候（也就是单例中不存在），需要将该Bean实例化
     * @param name 要检索的bean的名称
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    /**
     *  根据Bean的名字 获取Bean实例信息
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创造Bean
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}

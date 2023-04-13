package org.lrk.springframework.beans.factory.support;

import org.lrk.springframework.beans.BeansException;
import org.lrk.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: lrk
 * @Date: 2023/4/13 上午 9:57
 * @Description: JDK实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    /**
     * 使用JDK实例化Bean
     * @param beanDefinition Bean的定义
     * @param beanName Bean的名字
     * @param ctor 一些必须的类的信息
     * @param args 构造Bean的构造参数
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor){
                //不为空，说明是有参构造
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                //否则，是无参构造
                return clazz.getDeclaredConstructor().newInstance();
            }
        }catch (Exception e){
            throw new BeansException("实例化[ " + clazz.getName() + " ] 失败， " + e);
        }
    }
}

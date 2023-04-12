package org.lrk.springframework.beans.factory.config;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 7:35
 * @Description: 单例对象注册接口的定义
 */
public interface SingletonBeanRegistry {
    /**
     * 获取单例对象
     * @param beanName bean的名字
     * @return bean
     */
    Object getSingleton(String beanName);

    /**
     * 注册一个单例对象到Bean容器中
     * @param beanName bean名字
     * @param singletonObject 单例对象
     */
    void registerSingleton(String beanName, Object singletonObject);
}

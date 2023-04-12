package org.lrk.springframework.beans.factory.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 7:44
 * @Description: 默认实现 单例注册类
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{
    /**
     * 存放单例对象的map
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 根据bean名称获取单例
     * @param beanName bean的名字
     * @return
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 注册单例到容器中
     * @param beanName bean名字
     * @param singletonObject 单例对象
     */
    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}

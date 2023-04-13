package org.lrk.springframework.beans.factory.config;

import org.lrk.springframework.beans.PropertyValues;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 7:29
 * @Description: Bean的实例信息
 */
public class BeanDefinition {
    /**
     * Bean的Class
     */
    private Class beanClass;
    /**
     * 属性集合
     */
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        // 如果传进来的propertyValues为null，则需要自己创建一个
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        propertyValues = new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

}

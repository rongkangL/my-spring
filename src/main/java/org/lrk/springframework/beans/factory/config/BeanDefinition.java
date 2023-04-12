package org.lrk.springframework.beans.factory.config;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 7:29
 * @Description: Bean的实例信息
 */
public class BeanDefinition {
    //不需要将实例化信息注册到Bean容器中，只需要将Class注册到容器中就可以了
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}

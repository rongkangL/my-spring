package org.lrk.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.lrk.springframework.beans.BeansException;
import org.lrk.springframework.beans.PropertyValue;
import org.lrk.springframework.beans.PropertyValues;
import org.lrk.springframework.beans.factory.config.BeanDefinition;
import org.lrk.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 7:59
 * @Description:
 */
public abstract class AbstractAutowireCapableBeanFactory  extends AbstractBeanFactory{

    /**
     * 对象实例化策略属性类，默认Cglib实现
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     * 创造Bean
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            //bean = beanDefinition.getBeanClass().newInstance();
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("创建Bean失败", e);
        }
        // 将Bean注册为单例
        registerSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 获取所有的构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        // 进行简单的循环比对，这里比对的是参数是否为null并且参数的集合是否等于传入参数的集合
        // 而在Spring框架中，还需要比对入参类型等等
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length){
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     *  填充属性，如果遇到是Bean引用，则从容器中获取Bean实例，填充
     * @param beanName bean的名字
     * @param bean bean的实例
     * @param beanDefinition bean的定义
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition){
        try {
            // 获取Bean定义中的属性集合
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                // 获取属性名
                String name = propertyValue.getName();
                // 获取属性值
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference){
                    // 值属于Bean引用
                    BeanReference beanReference = (BeanReference) value;
                    // 从根据Bean引用的名字，从容器中获取其实例
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        }catch (Exception e){
            throw new BeansException("填充Bean属性值失败，values: " + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}

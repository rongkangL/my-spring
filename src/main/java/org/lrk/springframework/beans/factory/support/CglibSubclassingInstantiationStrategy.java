package org.lrk.springframework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.lrk.springframework.beans.BeansException;
import org.lrk.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import java.lang.reflect.Constructor;

/**
 * @Author: lrk
 * @Date: 2023/4/13 上午 10:02
 * @Description: 使用Cglib实例化
 */
public class CglibSubclassingInstantiationStrategy implements  InstantiationStrategy{
    /**
     * 使用Cglib进行实例化
     * @param beanDefinition Bean的定义
     * @param beanName Bean的名字
     * @param ctor 一些必须的类的信息
     * @param args 构造Bean的构造参数
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor){
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}

package org.lrk.springframework.test;

import org.junit.Test;
import org.lrk.springframework.beans.PropertyValue;
import org.lrk.springframework.beans.PropertyValues;
import org.lrk.springframework.beans.factory.config.BeanDefinition;
import org.lrk.springframework.beans.factory.config.BeanReference;
import org.lrk.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.lrk.springframework.test.bean.UserDao;
import org.lrk.springframework.test.bean.UserService;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 9:55
 * @Description:
 */

public class ApiTest {

    @Test
    public void testBeanFactory1() {
        // 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //获取Bean对象
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        //再次获取Bean对象
        UserService userServiceSingleton = (UserService) beanFactory.getBean("userService");
        userServiceSingleton.queryUserInfo();

        System.out.println(userService == userServiceSingleton);
    }

    @Test
    public void testBeanFactory2() {
        // 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService", "小黑子");
        System.out.println(userService);
    }

    @Test
    public void testBeanFactory3() {
        // 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();


        // UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 使用UserService 填充属性 （uId, userDao）
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 使用UserService注册Bean对象
        BeanDefinition userServiceBeanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", userServiceBeanDefinition);

        //使用UserService获取Bean对象
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}

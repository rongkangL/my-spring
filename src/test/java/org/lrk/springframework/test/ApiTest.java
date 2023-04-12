package org.lrk.springframework.test;

import org.junit.Test;
import org.lrk.springframework.beans.factory.config.BeanDefinition;
import org.lrk.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.lrk.springframework.test.bean.UserService;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 9:55
 * @Description:
 */

public class ApiTest {

    @Test
    public void testBeanFactory() {
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
}

package org.lrk.springframework.beans.factory.config;

/**
 * @Author: lrk
 * @Date: 2023/4/13 下午 2:31
 * @Description: Bean 引用 用来表示已经注入到容器中了
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}

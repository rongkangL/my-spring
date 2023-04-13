package org.lrk.springframework.beans;

/**
 * @Author: lrk
 * @Date: 2023/4/13 下午 2:12
 * @Description: Bean 属性信息
 */
public class PropertyValue {
    /**
     * 属性名
     */
    private final String name;
    /**
     * 属性值
     */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

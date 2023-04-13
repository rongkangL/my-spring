package org.lrk.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lrk
 * @Date: 2023/4/13 下午 2:14
 * @Description: Bean属性值集合
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();
    public void addPropertyValue(PropertyValue propertyValue){
        propertyValueList.add(propertyValue);
    }

    /**
     * 转化为PropertyValue集合转化为数组
     * @return
     */
    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据属性名找到对应的PropertyValue类
     * @param propertyName
     * @return
     */
    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equals(propertyName)){
                return propertyValue;
            }
        }
        return null;
    }

}

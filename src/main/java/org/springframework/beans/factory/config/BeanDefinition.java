package org.springframework.beans.factory.config;


import org.springframework.beans.PropertyValues;

// 存储bean的scope class 等信息 这里简化为只储存类
public class BeanDefinition {
    private Class beanClass;
    private PropertyValues propertyValues;



    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }
    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
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

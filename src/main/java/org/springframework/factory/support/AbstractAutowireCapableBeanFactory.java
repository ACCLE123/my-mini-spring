package org.springframework.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.BeansException;
import org.springframework.factory.PropertyValue;
import org.springframework.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        return doCreateBean(beanName, beanDefinition);
    }

    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition);
            applyPropertyValues(bean, beanName, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }


    protected Object createBeanInstance(BeanDefinition beanDefinition) throws BeansException {
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    protected void applyPropertyValues(Object bean, String beanName, BeanDefinition beanDefinition) throws BeansException {
        try {
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                Object value = propertyValue.getValue();
                String name = propertyValue.getName();
                BeanUtil.setProperty(bean, name, value);
            }
        } catch (Exception ex) {
            throw new BeansException("Error setting property values for bean: " + beanName, ex);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}

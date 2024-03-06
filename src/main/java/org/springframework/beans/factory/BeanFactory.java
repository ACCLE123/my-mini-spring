package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    <T> T getBean(String beanName, Class<T> requiredType) throws BeansException;
}

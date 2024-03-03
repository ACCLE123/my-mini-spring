package org.springframework.factory.support;

import org.springframework.BeansException;
import org.springframework.factory.config.BeanDefinition;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}

package org.springframework.factory;

import org.springframework.BeansException;

import java.util.HashMap;
import java.util.Map;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
}

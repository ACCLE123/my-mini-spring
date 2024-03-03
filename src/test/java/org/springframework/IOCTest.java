package org.springframework;

import org.junit.Test;
import org.springframework.factory.config.BeanDefinition;
import org.springframework.factory.support.DefaultListableBeanFactory;

public class IOCTest {
    @Test
    public void test() throws BeansException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("helloService", new BeanDefinition(HelloService.class));
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();
    }
}


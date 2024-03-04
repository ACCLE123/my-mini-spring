package org.springframework;

import org.junit.Test;
import org.springframework.bean.Car;
import org.springframework.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PopulateBeanWithPropertyValuesTest {
    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValues.addPropertyValue(new PropertyValue("age", 18));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertThat(person.getName()).isEqualTo("derek");
        assertThat(person.getAge()).isEqualTo(18);
    }

    @Test
    public void testPopulateBeanWithBean() throws BeansException {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        PropertyValues carPropertyValues= new PropertyValues();
        carPropertyValues.addPropertyValue(new PropertyValue("brand", "ferrari"));
        defaultListableBeanFactory.registerBeanDefinition("car", new BeanDefinition(Car.class, carPropertyValues));


        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "yangqi"));
        propertyValues.addPropertyValue(new PropertyValue("age", 21));
        propertyValues.addPropertyValue(new PropertyValue("car", new BeanReference("car")));
        defaultListableBeanFactory.registerBeanDefinition("person", new BeanDefinition(Person.class, propertyValues));

        Person person = (Person) defaultListableBeanFactory.getBean("person");
        System.out.println(person);

    }
}


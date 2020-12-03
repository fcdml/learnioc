package com.mytry.code.beans;

/**
 * @Classname BeanDefinition
 * @Description TODO
 * @Date 2020/12/3 20:57
 * @Created by 2413776263@qq.com
 */
public class BeanDefinition {
//do what???
    private  Object bean;
    //bean的类
    private Class beanClass;
    //TODO 要根据 beanClassName 就是(com....)   通过放射 拿到Class对象
    private String beanClassName;
     private PropertyValues propertyValues;
    public BeanDefinition() {
    }
    public BeanDefinition(Object bean) {
        this.bean = bean;
    }
    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
    public Class getBeanClass() {
        return beanClass;
    }
    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("42-------ClassNotFoundException---------" + beanClassName);
            e.printStackTrace();
        }
    }
}

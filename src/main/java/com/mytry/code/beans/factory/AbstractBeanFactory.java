package com.mytry.code.beans.factory;

import com.mytry.code.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname AbstractBeanFactory
 * @Description TODO
 * @Date 2020/12/3 21:20
 * @Created by 2413776263@qq.com
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<String, BeanDefinition>();
   // 存放beandefinition的名字
    private final List<String>  beanDefinitionNames=new ArrayList<String>();
    @Override
    public Object getBean(String name) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition==null){
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean==null){
            bean= doCreateBean(beanDefinition);
        }
      return bean;
    }
    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
                 beanDefinitionMap.put(name, beanDefinition);
                 beanDefinitionNames.add(name);
    }
    // 此方法的用途
    public void preInstantiateSingletons() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        //TODO 迭代器的语法
        for (Iterator it = this.beanDefinitionNames.iterator();
             it.hasNext();) {
            String beanName=(String)it.next();
         getBean(beanName);
        }
    }

     protected  abstract Object doCreateBean(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException, NoSuchFieldException;
}

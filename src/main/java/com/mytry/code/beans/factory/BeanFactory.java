package com.mytry.code.beans.factory;

import com.mytry.code.beans.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname BeanFactory
 * @Description TODO
 * @Date 2020/12/3 21:03
 * @Created by 2413776263@qq.com
 */
public interface BeanFactory {
  //获取Bean
  public Object getBean(String name) throws IllegalAccessException, NoSuchFieldException, InstantiationException;
   //注册BeanDefinition
   public void  registerBeanDefinition(String name,BeanDefinition beanDefinition) throws IllegalAccessException, NoSuchFieldException, InstantiationException;

}

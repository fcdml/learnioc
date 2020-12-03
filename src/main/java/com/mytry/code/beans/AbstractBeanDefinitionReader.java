package com.mytry.code.beans;

import com.mytry.code.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname AbstractBeanDefinitionReader
 * @Description TODO 从
 * @Date 2020/12/3 23:43
 * @Created by 2413776263@qq.com
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefibitionReader {
   private Map<String, BeanDefinition> registry;
   private ResourceLoader resourceLoader;
protected  AbstractBeanDefinitionReader (ResourceLoader resourceLoader){
 this.registry=new HashMap<String, BeanDefinition>();
this.resourceLoader=resourceLoader;
}
    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}

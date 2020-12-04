package com.mytry.code.beans.factory;

import com.mytry.code.beans.BeanDefinition;
import com.mytry.code.beans.BeanReference;
import com.mytry.code.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * @Classname AutowireCapableBeanFactory
 * @Description TODO 可自动装配内容的BeanFactory
 * @Date 2020/12/3 21:27
 * @Created by 2413776263@qq.com
 *
 * @author yihua.huang@dianping.com
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
            //REM 通过反射创建对象 newInstance  这个对象只能调用无参构造 由newInstance的特性决定
            Object bean = createBeanInstance(beanDefinition);
            beanDefinition.setBean(bean);
            applyPropertyValues(bean,beanDefinition);
            return bean;
    }
    //REM 主要的作用就是用来保护子类的。它的含义在于子类可以用它修饰的成员，其他的不可以，它相当于传递给子类的一种继承的东西
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }
    protected void applyPropertyValues(Object bean,BeanDefinition beanDefinition) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        for (PropertyValue propertyValue:
             beanDefinition.getPropertyValues().getPropertyValueArrayList()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
          declaredField.setAccessible(true);
          Object value=propertyValue.getValue();
          if (value instanceof BeanReference){
              BeanReference value1 = (BeanReference) value;
              value=getBean(value1.getName());
          }
          //REM 给bean属性设置值为propertyValue.getValue()
          declaredField.set(bean,value);
        }
    }

}

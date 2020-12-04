package com.mytry.code.beans;

/**
 * @Classname BeanReference
 * @Description TODO bean对象注入name为某某的bean中去  bean对象2号 注入bean对象1号中 那么要先等bean1号 初始化完 bean2号再进行初始化 即lazy-init
 *                --- 这里需要实现下面的
 *                spring中 lazy-init="true" 延迟加载， 表示bean1号调用bean2号时才进行加载实例化。 （lazy-init 设置只对scop属性为singleton的bean起作用）
 * @Date 2020/12/4 11:04
 * @Created by 2413776263@qq.com
 */
public class BeanReference {
    private String name;
    private Object bean;
    public BeanReference(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}

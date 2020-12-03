package com.mytry.code.beans;

/**
 * @Classname PropertyValue
 * @Description TODO  用于bean的属性注入
 * @Date 2020/12/3 21:56
 * @Created by 2413776263@qq.com
 */
public class PropertyValue {
    private final String name;
    private final Object value;
    //TODO final 修饰成员变量的问题
    //  final的成员变量可以定义的时候直接赋值，声明时不赋值，在构造代码块中赋值 或者使用构造方法在构造方法体里面赋值，但是只能三者选其一
    // 被final static修饰的变量：两种赋值方式
    // 在定义时直接赋值.
    // 在静态代码块里赋值
    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public Object getValue() {
        return value;
    }
}

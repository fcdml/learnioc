package com.mytry.code.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PropertyValues
 * @Description TODO
 * @Date 2020/12/3 22:10
 * @Created by 2413776263@qq.com
 */
public class PropertyValues {
    private  final  List<PropertyValue> propertyValueArrayList=new ArrayList<PropertyValue>();
    public PropertyValues() {
    }
     public  void addPropertyValue(PropertyValue pv){
         System.out.println(pv.getName()+pv.getValue());
        this.propertyValueArrayList.add(pv);
     }
    public List<PropertyValue> getPropertyValueArrayList() {
        return propertyValueArrayList;
    }
}

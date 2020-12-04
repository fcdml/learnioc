package com.mytry.code;

import static org.junit.Assert.assertTrue;

import com.mytry.code.beans.BeanDefinition;
import com.mytry.code.beans.factory.AbstractBeanFactory;
import com.mytry.code.beans.factory.AutowireCapableBeanFactory;
import com.mytry.code.beans.io.ResourceLoader;
import com.mytry.code.beans.xml.XmlBeanDefinitionReader;
import com.mytry.code.context.ApplicationContext;
import com.mytry.code.context.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void shouldAnswerWith() throws ParserConfigurationException, SAXException, IOException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("learnioc.xml");
        AutowireCapableBeanFactory autowireCapbleBeanFactory = new AutowireCapableBeanFactory();
        //TODO  entryset是什么
        for (Map.Entry<String, BeanDefinition> s:xmlBeanDefinitionReader.getRegistry().entrySet()){
            autowireCapbleBeanFactory.registerBeanDefinition(s.getKey(),s.getValue());
            System.out.println(s);
        }
        HelloWorldService helloWorldService = (HelloWorldService) autowireCapbleBeanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
        assertTrue( true );
    }
    @Test
    public void testPreInstantiate() throws ParserConfigurationException, SAXException, IOException, IllegalAccessException, NoSuchFieldException, InstantiationException, ClassNotFoundException {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("learnioc.xml");
        AbstractBeanFactory abstractBeanFactory = new AutowireCapableBeanFactory();
        //初始化BeanFactory 并注册bean
        for (Map.Entry<String,BeanDefinition> beanDefinitionEntry:
             xmlBeanDefinitionReader.getRegistry().entrySet()) {
            abstractBeanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());

        }
       // 初始化bean
        abstractBeanFactory.preInstantiateSingletons();
        HelloWorldService helloWorldService = (HelloWorldService) abstractBeanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
        helloWorldService.getOutPutService().output("2222");
        for (String beanDefinitionName : abstractBeanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
//        PropertyValues propertyValues = new PropertyValues();
//        List<PropertyValue> propertyValueArrayList = propertyValues.getPropertyValueArrayList();
//        System.out.println(propertyValueArrayList.size());
    }
    // 测试ClassPathXmlApplicationContext  获取bean
    @Test
    public void test() throws IllegalAccessException, InstantiationException, NoSuchFieldException, SAXException, ParserConfigurationException, IOException {
//       TODO 接口指向堆中的 对象 多态的表现 Java在利用接口变量调用其实现类的对象的方法时，该方法必须已经在接口中被声明 这里是ApplicationContext 去找的父接口的方法
         ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("learnioc.xml");
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("learnioc.xml");
        //子类对象调用方法 本类找不到就去父类找
        HelloWorldService helloWorldService = (HelloWorldService)classPathXmlApplicationContext.getBean("helloWorldService");
      helloWorldService.helloWorld();
        helloWorldService.getOutPutService().output("rrr");

    }

}

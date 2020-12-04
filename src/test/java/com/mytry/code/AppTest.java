package com.mytry.code;

import static org.junit.Assert.assertTrue;

import com.mytry.code.beans.BeanDefinition;
import com.mytry.code.beans.factory.AbstractBeanFactory;
import com.mytry.code.beans.factory.AutowireCapableBeanFactory;
import com.mytry.code.beans.io.ResourceLoader;
import com.mytry.code.beans.xml.XmlBeanDefinitionReader;
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
        AutowireCapableBeanFactory autowireCapableBeanFactory = new AutowireCapableBeanFactory();
        //entryset是什么
        for (Map.Entry<String, BeanDefinition> s:xmlBeanDefinitionReader.getRegistry().entrySet()){
            autowireCapableBeanFactory.registerBeanDefinition(s.getKey(),s.getValue());
            System.out.println(s);
        }
        HelloWorldService helloWorldService = (HelloWorldService) autowireCapableBeanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
        assertTrue( true );
    }
    @Test
    public void testPreInstantiate() throws ParserConfigurationException, SAXException, IOException, IllegalAccessException, NoSuchFieldException, InstantiationException {
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
    }
}

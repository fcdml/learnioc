package com.mytry.code.context;

import com.mytry.code.beans.BeanDefinition;
import com.mytry.code.beans.BeanReference;
import com.mytry.code.beans.factory.AbstractBeanFactory;
import com.mytry.code.beans.factory.AutowireCapableBeanFactory;
import com.mytry.code.beans.io.ResourceLoader;
import com.mytry.code.beans.xml.XmlBeanDefinitionReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

/**
 * @Classname ClassPathXmlApplicationContext
 * @Description TODO
 * @Date 2020/12/4 19:38
 * @Created by 2413776263@qq.com
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws IllegalAccessException, ParserConfigurationException, InstantiationException, IOException, SAXException, NoSuchFieldException {
       //TODO ????两个参数传给谁 --调用下面的两参构造
        this(configLocation,new AutowireCapableBeanFactory() );
    }

    public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory beanFactory ) throws IllegalAccessException, SAXException, NoSuchFieldException, InstantiationException, ParserConfigurationException, IOException {
        super(beanFactory);
        this.configLocation = configLocation;
      refresh();
    }
    @Override
    public void refresh() throws ParserConfigurationException, SAXException, IOException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry:
             xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

    }
}

package com.mytry.code.context;

import com.mytry.code.beans.factory.AbstractBeanFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @Classname AbstractApplicationContext
 * @Description TODO
 * @Date 2020/12/4 19:32
 * @Created by 2413776263@qq.com
 */
public class AbstractApplicationContext implements ApplicationContext {
  protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    public void refresh() throws ParserConfigurationException, SAXException, IOException, IllegalAccessException, NoSuchFieldException, InstantiationException {
    }
    @Override
    public Object getBean(String name) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        return beanFactory.getBean(name);
    }
}

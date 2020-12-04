package com.mytry.code.xml;

import com.mytry.code.beans.BeanDefinition;
import com.mytry.code.beans.io.ResourceLoader;
import com.mytry.code.beans.xml.XmlBeanDefinitionReader;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

/**
 * @Classname XmlBeanDefinitionReaderTest
 * @Description TODO
 * @Date 2020/12/4 8:28
 * @Created by 2413776263@qq.com
 */
public class XmlBeanDefinitionReaderTest {
@Test
    public void test() throws ParserConfigurationException, SAXException, IOException {
    XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
     xmlBeanDefinitionReader.loadBeanDefinitions("learnioc.xml");
    Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
    Assert.assertTrue(registry.size()>0);

}



}

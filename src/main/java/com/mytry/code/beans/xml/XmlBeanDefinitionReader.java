package com.mytry.code.beans.xml;

import com.mytry.code.beans.AbstractBeanDefinitionReader;
import com.mytry.code.beans.BeanDefinition;
import com.mytry.code.beans.BeanReference;
import com.mytry.code.beans.PropertyValue;
import com.mytry.code.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
/**
 * @Classname XmlBeanDefinitionReader
 * @Description TODO
 * @Date 2020/12/3 23:50
 * @Created by 2413776263@qq.com
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws IOException, ParserConfigurationException, SAXException {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
     //REM parse将给定InputStream的内容解析为XML文档，并返回一个新的DOM Document对象
        Document doc = documentBuilder.parse(inputStream);
        //TODO 解析Bean
         registerBeanDefinitions(doc);
        inputStream.close();
    }
    public void registerBeanDefinitions(Document doc) {
        Element root = doc.getDocumentElement();
    parseBeanDefinitions(root);
    }
    protected void parseBeanDefinitions(Element root) {
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i <childNodes.getLength() ; i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element){
                Element newitem = (Element) item;
                processBeanDefinition(newitem);
            }
        }

    }
   protected void processBeanDefinition(Element newitem) {
    String name=newitem.getAttribute("name");
       String className = newitem.getAttribute("class");
       BeanDefinition beanDefinition = new BeanDefinition();
       processProperty(newitem,beanDefinition);
        beanDefinition.setBeanClassName(className);
       //调用 父类中的方法 由于方法返回值是map 所有 getRegistry()相当于是个map 所有后面能点出map的方法
       // REM 这个名字是bean的名字
       //  <bean name="user" class="com.chy.bean.User" />
       getRegistry().put(name,beanDefinition);
   }
    private void processProperty(Element newitem, BeanDefinition beanDefinition) {
        NodeList property = newitem.getElementsByTagName("property");
        for (int i = 0; i <property.getLength() ; i++) {
            Node node = property.item(i);
            if (node instanceof Element){
                Element node1 = (Element) node;
                String name = node1.getAttribute("name");
                String value = node1.getAttribute("value");
                if (value!=null && value.length()>0){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                }else {
                  String ref=node1.getAttribute("ref");
                  if (ref==null||ref.length()==0){
                      throw  new IllegalArgumentException("Configuration problem: <property> element for property '"
                              + name + "' must specify a ref or value");
                  }
                    BeanReference beanReference = new BeanReference(ref);
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,beanReference));
                }
            }
        }
    }
}

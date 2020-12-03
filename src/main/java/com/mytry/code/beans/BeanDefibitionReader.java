package com.mytry.code.beans;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * TODO  从配置中读取BeanDefinitionReader
 */
public interface BeanDefibitionReader {

  void loadBeanDefinitions(String location) throws IOException, ParserConfigurationException, SAXException;
}

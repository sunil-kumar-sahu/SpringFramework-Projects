package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.comp.Flipkart;

public class StartegyDPTest2{
  public static void main(String[] args) {
	DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
	XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
	reader.loadBeanDefinitions("applicationContext.xml");
	System.out.println("BF Container is created...");
	  //get Target Class obj
	  Flipkart fpkt=factory.getBean("fpkt",Flipkart.class);
	  //invoke the b.method
	  String resultMsg=fpkt.shopping(new String[] {"shirt","trouser","glasses"},new float[] {5679.06f,5557.55f,4545.77f});
	  System.out.println(resultMsg);
	  
	
}
}

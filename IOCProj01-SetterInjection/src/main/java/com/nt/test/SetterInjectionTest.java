package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		//Hold Spring bean cfg file name and location(ctrl+shift+o::To import pkg)
		FileSystemResource res=new FileSystemResource("src/main/java/com/nt/cfgs/applicationContext.xml");
		//create IOC container(BeanFactory container)
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Target spring bean class object
			WishMessageGenerator generator=factory.getBean("wmg",WishMessageGenerator.class);	
		//invoke the b.method
		String result=generator.generateMessage("raja");
		System.out.println("Wish Message is::"+result);
		
		}

}
 
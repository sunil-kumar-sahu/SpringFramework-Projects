package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		//Hold Spring bean cfg file name and location(ctrl+shift+o::To import pkg)
		FileSystemResource res=new FileSystemResource("src/main/java/com/nt/cfgs/applicationContext.xml");
		//Hold Spring bean cfg file name and location(ctrl+shift+o::To import pkg)

		//create IOC container(BeanFactory container)
		XmlBeanFactory factory=new XmlBeanFactory(res);
		//get Target spring bean class object
		WishMessageGenerator generator=factory.getBean("wmg",WishMessageGenerator.class);	
		//invoke the b.method
		String result=generator.generateMessage("raja");
		System.out.println("Wish Message is::"+result);
		
		}

}

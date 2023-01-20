package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comp.Flipkart;

public class StartegyDPTest1 {
  public static void main(String[] args) {
	//ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	
	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	/*  //get Target Class obj
	  Flipkart fpkt=ctx.getBean("fpkt",Flipkart.class);
	  //invoke the b.method
	  String resultMsg=fpkt.shopping(new String[] {"shirt","trouser","glasses"},new float[] {5679.06f,5557.55f,4545.77f});
	  System.out.println(resultMsg);
	  
	  ctx.close();*/
}
}

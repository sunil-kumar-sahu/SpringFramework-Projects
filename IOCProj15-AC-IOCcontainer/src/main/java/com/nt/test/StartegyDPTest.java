package com.nt.test;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.comp.Flipkart;

public class StartegyDPTest {
  public static void main(String[] args) {
	FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
	  //get Target Class obj
	  Flipkart fpkt=ctx.getBean("fpkt",Flipkart.class);
	  //invoke the b.method
	  String resultMsg=fpkt.shopping(new String[] {"shirt","trouser","glasses"},new float[] {5679.06f,5557.55f,4545.77f});
	  System.out.println(resultMsg);
	  
	  ctx.close();
}
}

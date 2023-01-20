package com.nt.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Cricketer;

public class DependencyLookupTest {
	public static void main(String[] args) {
  //create IOC container
	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	//get target class
	Cricketer player=ctx.getBean("cktr",Cricketer.class);
	System.out.println(player.getClass()+" "+player.getClass().getSuperclass()+" "+Arrays.toString(player.getClass().getDeclaredMethods()));
	//invoke methods
	player.batting();
	player.batting();
	player.bowling();
	player.fielding();
	}
}

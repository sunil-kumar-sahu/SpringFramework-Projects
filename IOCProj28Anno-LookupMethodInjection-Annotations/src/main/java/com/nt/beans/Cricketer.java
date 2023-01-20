package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component("cktr")
public abstract class Cricketer{
//no HAS-A property of dependent class
	
	
	public Cricketer() {
		System.out.println("Cricketer::0-param constructor"+this.getClass());
	}
	public void bowling() {
		System.out.println("Cricketer is bowling");
	}
	
	@Lookup
	public abstract Bat createBat();
	public void batting() {
		System.out.println("Cricketer is batting");
		//perform dependancy lookup method to get Dependent class object
		Bat bat=createBat();
		//invoke methods
		int score=bat.scoreRuns();
		System.out.println("Cricketer batting score is::"+score);
	}
	
	public void fielding(){
		System.out.println("Cricketer is fielding");
	}
	public void wicketKeeping() {
		System.out.println("Cricketer is keeping the wickets");
	}
}

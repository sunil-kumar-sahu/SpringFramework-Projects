//WishMessageGenerator.java
package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
 //HAS-A property (supporting composition)
	private Date date;
	
	//for constructor Injection
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-param constructor");
	}
	public WishMessageGenerator(Date date) {
		System.out.println("WishMessageGenerator:1-param constructor");
		this.date=date; 
	}
	
	//B.method
	public String generateMessage(String user) {
		System.out.println("WishMessageGenerator.generateMessage()");
		//get current of the day
		int hour=date.getHours();//24 hours format(0 to 23)
		//generate wish message
		if(hour<12)
			return "Good Morning::"+user;
		if(hour<16)
			return "Good AfterNoon::"+user;
		if(hour<20)
			return "Good Evening::"+user;
		else
			return "Good Night::"+user;
	}
	 
}

package com.nt.beans;

import java.util.Date;

public class VotingEligibilityCheck {
  //bean properties
	private String name;
	private int age;
	private String addrs;
	private Date verifiedOn;
	//setter methods for setter injection
	public void setName(String name) {
		System.out.println("VotingEligibilityCheck.setName(-)");
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("VotingEligibilityCheck.setAge(-)");
		this.age = age;
	}
	public void setAddrs(String addrs) {
		System.out.println("VotingEligibilityCheck.setAddrs(-)");
		this.addrs = addrs;
	}
	
	//custom init method
	public void myInit() {
		System.out.println("VotingEligibilityCheck.myInit()");
		//initialize left over properties
		verifiedOn=new Date();
		if(addrs==null)
			addrs="no provided";
		//validation logic
		if(name==null)
			throw new IllegalArgumentException("Name is required");
		else if(age<=0 || age>=126)
			throw new IllegalArgumentException("Person age must be in the range of 1 through 125");
	}
	
	//b.method
	public String chcckVotingCriteria() {
		//b.logic
		if(age<18)
			return "Mr./Miss/Mrs."+name+"("+age+")"+"belongs to "+addrs+" is not eligible for voting-->verified on::"+verifiedOn;
		else
			return "Mr./Miss/Mrs."+name+"("+age+")"+"belongs to "+addrs+" is eligible for voting-->verified on::"+verifiedOn;
	}
	
	public void myDestroy() {
		System.out.println("VotingEligibilityCheck.myDestroy()");
		//nullify bean property
		name=null;
		age=0;
		verifiedOn=null;
		addrs=null;
	}
	
}

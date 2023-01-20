package com.nt.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("voting")
@PropertySource("com/nt/commons/info.properties")
public class VotingEligibilityCheck {
  //bean properties
	@Value("${per.name}")
	private String name;
	@Value("${per.age}")
	private int age;
	@Value("${per.addrs}")
	private String addrs;
	private Date verifiedOn;
	
	
	@PostConstruct 
	public void custInit() {
		System.out.println("VotingEligibilityCheck.custInt()");
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
		public String chcekVotingCriteria() {
			//b.logic
			if(age<18)
				return "Mr./Miss/Mrs."+name+"("+age+")"+"belongs to "+addrs+" is not eligible for voting-->verified on::"+verifiedOn;
			else
				return "Mr./Miss/Mrs."+name+"("+age+")"+"belongs to "+addrs+" is eligible for voting-->verified on::"+verifiedOn;
		}
	
	@PreDestroy
	public void custDestroy() {
		System.out.println("VotingEligibilityCheck.custDestroy()");
		//nullify bean property
		name=null;
		age=0;
		verifiedOn=null;
		addrs=null;
	}

	
}

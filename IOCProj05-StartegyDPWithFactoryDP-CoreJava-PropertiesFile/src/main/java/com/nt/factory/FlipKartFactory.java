package com.nt.factory;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.nt.comp.Courier;
import com.nt.comp.Flipkart;

public class FlipKartFactory {
	private static Properties props;
	static {
		System.out.println("FlipkartFactory.static block");
		try( 
			//Load properties file
			FileInputStream fis=new FileInputStream("src/main/java/com/nt/commons/info.properties")){
			//load properties file content to java.util.Properties class obj
			props=new Properties();
			props.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
 
	//static factory method supporting Factory  pattern 
	public static Flipkart createFlipkart()throws Exception {
		//create terget class obj
		Flipkart fpkt=new Flipkart();
		
		//Load Dependent class
		Class c=Class.forName(props.getProperty("dependent.comp"));
		//create object using reflection api
		Constructor cons[]=c.getDeclaredConstructors();
		//create object
		Courier courier=(Courier) cons[0].newInstance();
	    
		//set Dependent class object to target class obj
		fpkt.setCourier(courier);
		return fpkt;
	}
}
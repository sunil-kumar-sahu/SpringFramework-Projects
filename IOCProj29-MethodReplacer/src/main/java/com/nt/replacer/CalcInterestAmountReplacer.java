package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class CalcInterestAmountReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("CalcInterestAmountReplacer.reimplement()(Simple interest)");
		//get target method arg values
		double pamt=(double)args[0];
		double rate=(double)args[1];
		double time=(double)args[2];
		//write new logic to execute(simpleInterest amount)
		return pamt*rate*time/100;
	}

}

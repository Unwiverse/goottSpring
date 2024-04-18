package com.spring.aop03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx= 
				new GenericXmlApplicationContext("classpath:aop03.xml");
		
		Emergency onpc = ctx.getBean("onpc", Emergency.class);
		onpc.whatthefuck();
		
		System.out.println();
		
		Emergency ontablet = ctx.getBean("ontablet", Emergency.class);
		ontablet.whatthefuck();
		
		ctx.close();

	}

}

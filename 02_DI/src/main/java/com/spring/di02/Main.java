package com.spring.di02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class Main {

	public static void main(String[] args) {
		
		// 스프링 컨테이너를 생성해야 됨.
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:hello.xml");
		// 스프링 컨테이너를 써서 빈을 가져와야 됨.
		//MessageImpl msg = ctx.getBean("msg", MessageImpl.class);
		MessageImpl msg = (MessageImpl)ctx.getBean("message");
		System.out.println(); 
		msg.msg();
		
		ctx.close();
	}

		
		  
	}



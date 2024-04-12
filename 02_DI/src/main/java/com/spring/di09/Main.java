package com.spring.di09;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.di08.Config;

public class Main {

	public static void main(String[] args) {
		// 스프링 컨테이너를 생성해야 됨.
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:pc.xml");
		
		AnnotationConfigApplicationContext ctt =
				new AnnotationConfigApplicationContext //스프링 컨테이너
				(Config.class); //Config 클래스 로딩
		
		PCspec spec = ctx.getBean("no.1", PCspec.class); 
		
		System.out.println("CPU: "+spec.getCpu());
		System.out.println("MB: "+spec.getMb());
		System.out.println("RAM: "+spec.getRam());
		System.out.println("RAMSIZE: "+spec.getRamsize());
		System.out.println("VGA: "+spec.getVga());
		System.out.println("SSD: "+spec.getSsd());
		System.out.println("HDD? "+spec.isHdd());
		System.out.println("PSU: "+spec.getPsu());
		
		System.out.println("::::::::::::::::::::::::");
		
		PCspec2 spec2 = ctt.getBean("no.2", PCspec2.class);
		
		System.out.println("CPU: "+spec2.getCpu());
		System.out.println("MB: "+spec2.getMb());
		System.out.println("RAM: "+spec2.getRam());
		System.out.println("VGA: "+spec2.getVga());
		System.out.println("SSD: "+spec2.getSsd());
		//hdd 존재 여부 확인
		if (spec2.getHdd()) {
            System.out.println("HDD: " + spec2.getHddModel());
        } else {
            System.out.println("HDD: No HDD");
        }
		System.out.println("PSU: "+spec2.getPsu());
	}

}

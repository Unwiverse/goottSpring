package com.spring.aop03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//advice(공통 관심사항) - 스프링에서 공통관심사항이 있는 코드들의 묶음.

@Component
@Aspect
public class AppliancesAspect {
	@Pointcut("execution(* whatthefuck())")
	public void myPointCut() {}
	
	@Before("myPointCut()")
	public void before() {
		System.out.println("롤하다 샷건침");
	}
	
	@AfterReturning("myPointCut()")
	public void after_returning() {
		System.out.println("고장은 막았으나 장치는 심각한 대미지를 입었다!");
	}
	
	@After("myPointCut()")
	public void after() {
		System.out.println("'열린 결말'");
	}
	
}

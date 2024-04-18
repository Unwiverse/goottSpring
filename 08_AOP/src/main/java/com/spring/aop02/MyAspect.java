package com.spring.aop02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// advice(공통 관심사항) - 스프링에서 공통관심사항이 있는 코드들의 묶음.

@Component
@Aspect // "공통관심사항이 모인 클래스다"라고 알려주는 annotation
public class MyAspect {
	
	@Pointcut("execution(* doSomething())")
	public void myPointCut() {}
	
	@Before("myPointCut()") //myPointCut()메서드 이전에 실행됨
	public void before() {
		System.out.println("학교에서 수업 후 집 열고 문 들어갑니다");
	}
	
	@AfterReturning("myPointCut()") //정상 실행 이후 나타남
	public void after_returning() {
		System.out.println("잠을 잡니다");
	}
	
	@AfterThrowing("myPointCut()") //예외 발생 시 나타남
	public void after_throwning() {
		System.out.println("화재 발생: 119 신고");
	}
	
	@After("myPointCut()")
	public void after() {
		System.out.println("아침에 일어나 등교하려고 집나옴");//예외가 실행되던 안되던 실행됨
	}
	
}

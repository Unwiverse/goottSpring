package com.spring.aop01;

// advice(공통 관심사항) - 스프링에서 공통관심사항이 있는 코드들의 묶음.


public class MyAspect {
	
	public void before() {
		System.out.println("학교에서 수업 후 집 열고 문 들어갑니다");
	}
	public void after_returning() {
		System.out.println("잠을 잡니다");
	}
	public void after_throwning() {
		System.out.println("화재 발생: 119 신고");
	}
	public void after() {
		System.out.println("아침에 일어나 등교하려고 집나옴");//예외가 실행되던 안되던 실행됨
	}
	
	
}

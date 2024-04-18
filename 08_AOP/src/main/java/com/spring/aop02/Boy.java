package com.spring.aop02;

import org.springframework.stereotype.Component;

/*
 * 남자(청소년)
 * - 학교에서 수업 후 집에와서 문을 열고 집 들감. ==> 공통 관심사항(이전)
 * - 컴퓨터로 게임을 합니다.	                 ==> 핵심 기능
 * - 잠을 잡니다.							 --> 공통관심사항(이후)
 * - 화재 발생: 119 신고					 --> 공통관심사항(이후-예외)
 * - 아침에 일어나 문열고 등교하려고 집나옴		 --> 공통관심사항(이후)
 */

@Component
public class Boy implements Person{

	@Override
	public void doSomething() {
		
		System.out.println("컴퓨터로 게임함");
		
	}
		
}

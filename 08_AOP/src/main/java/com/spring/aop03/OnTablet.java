package com.spring.aop03;

public class OnTablet implements Emergency {

	@Override
	public void whatthefuck() {
		System.out.println("상황: 물쏟음");
		System.out.println("1. 전원을 끈다");
		System.out.println("2. 기기를 흔들어 물기를 뺀다");
		System.out.println("3. 물기 제거 기능이 있으면 쓴다");

	}

}

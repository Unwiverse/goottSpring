package com.spring.aop03;

public class OnPC implements Emergency {

	@Override
	public void whatthefuck() {
		System.out.println("상황: 물쏟음");
		System.out.println("1. 전원 차단한다");
		System.out.println("2. 케이스에서 내부 부품을 살피고 필요 시 꺼낸다");
		System.out.println("3. 쳐닦는다");

	}

}

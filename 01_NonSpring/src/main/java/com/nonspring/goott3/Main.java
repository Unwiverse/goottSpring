package com.nonspring.goott3;

public class Main {

	public static void main(String[] args) {
		// 영문으로 인사말을 전하고 싶으면
		// 1. 인자 생성자를 써서 객체를 주입
		
		/*
		 * Message msg = new MessageEN();
		 * 
		 * MessageImpl impl = new MessageImpl(new MessageKR());
		 * 
		 * 
		 * impl.msg();
		 */
		  
		 
		// 한글로 인사말을 전하고 싶으면
		// 2. setter() 메서드를 써서 주입
		
		  MessageImpl impl2 = new MessageImpl();
		  
		  impl2.setMessage(new MessageKR()); 
		  impl2.msg();
		
		  
	}

}

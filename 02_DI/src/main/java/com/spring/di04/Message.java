package com.spring.di04;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor  //기본생성자 Annotation
@AllArgsConstructor //인자생성자 Annotation
public class Message {
	private String msg;
	
	//비지니스 로직
	public void printMsg() {
		System.out.println("메세지: "+this.msg);
	}
}

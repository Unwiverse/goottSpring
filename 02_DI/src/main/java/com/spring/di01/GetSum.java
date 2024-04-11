package com.spring.di01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter/setter 메서드 자동생성 annotation
@NoArgsConstructor // 기본생성자 자동생성 annotation
@AllArgsConstructor // 인자생성자 자동생성 annotation

public class GetSum {
		
	private int su1;
	private int su2;
	//비지니스 로직
	public void hap() {
		System.out.println("더하기:"+(su1+su2));
	}
	
	
	
}

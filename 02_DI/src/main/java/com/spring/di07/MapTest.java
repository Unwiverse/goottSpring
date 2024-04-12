package com.spring.di07;

import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapTest {
	private Map<Integer, String> map;
	//비니리스 조릭
	void output() {
		// keySet(): Map에 있는 키를 전부 다 가져오는 메서드.
		Set<Integer> set = map.keySet();
		
		for(Integer k:set) {
			System.out.println(k+":"+map.get(k));
		}
		
	}
	
}

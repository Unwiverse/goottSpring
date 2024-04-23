package com.mybatis.model;

import java.util.List;
import java.util.Map;

public interface PCDAO {
	//시스템 전체 목록 조회 추상 메서드
	List<PC> getPCList();
	//시스템 하나 추가 추상 메서드
	int insertPC(PC dto);
	//시스템 하나 조회 추상 메서드 
	PC getPC(int no);
	//스시템 정보 수정 추상 메서드
	int updatePC(PC dto);
	//시스템 삭제 메서드 
	int deletePC(int no);
	//삭제하고 재정렬
	void updateSeq(int no);
	//검색 추상 메서드
	List<PC> searchPCList(Map<String, String> map);
}

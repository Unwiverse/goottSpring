package com.mybatis.model;

import java.util.List;
import java.util.Map;

public interface PMMDAO {
	
	//페이징 작업에 필요한 전체 게시물 수 확인 추상 메서드
	int getListCount(); 
	//페이징 처리 시 보여줄 게시물을 조회하는 추상 메서드
	List<PMM> getPCList(Page pdto);
	//시스템을 테이블에 추가하는 추상 메서드
	int insertPC(PMM dto);
	//시스템 정보 조회 추상 메서드
	PMM PCContent(int no);
	//시스템 정보 수정 추상 메서드
	int PCUpdate(PMM dto);
	//시스템 삭제 추상 메서드
	int deletePC(int no);
	//시스템 순번 재정렬 추상 메서드
	void updateSeq(int no);
	//검색 시 검색 내용에 해당하는 게시글의 수를 조회하는 추상 메서드
	int searchPCCount(Map<String, String> map);
	//검색 내용에 해당하는 게시글을 조회하는 추상 메서드
	List<PMM> searchPCList(Page pdto);
	
}

package com.mybatis.model;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

public interface BoardDAO {
	
	//페이징 작업에 필요한 전체 게시물 수 확인 추상 메서드
	int getListCount();
	//페이징 처리 시 보여줄 게시물을 조회하는 추상 메서드
	List<Board> getBoardList(Page pdto);
	//게시물을 board 테이블에 추가하는 추상 메서드
	int insertBoard(Board dto);
	//게시물 조회수를 증가시키는 추상 메서드
	void readCount(int no);
	//게시물의 상세 내역을 조회하는 추상 메서드
	Board boardContent(int no);
	//게시물을 수정하는 추상 메서드
	int updateBoard(Board dto);
	//게시물을 삭제하는 추상 메서드
	int deleteBoard(int no);
	//게삭 시 글번호 재정렬 추상 메서드
	void updateSeq(int no);
	//검색 시 검색 내용에 해당하는 게시글의 수를 조회하는 추상 메서드
	int searchBoardCount(Map<String, String> map);
	//검색 내용에 해당하는 게시글을 조회하는 추상 메서드
	List<Board> searchBoardList(Page pdto);
}

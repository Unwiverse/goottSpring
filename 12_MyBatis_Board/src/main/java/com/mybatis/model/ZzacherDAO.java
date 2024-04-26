package com.mybatis.model;

import java.util.List;


public interface ZzacherDAO {
	//추가
	public void addFile(ZzacherDTO file);
	//조회(사진)
	public ZzacherDTO findByBoardNo(int board_no);
	//삭제
	public void deleteFile(int no);

}

package com.mybatis.model;


import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ZzacherDAOImpl implements ZzacherDAO {
	
	@Inject
	private SqlSessionTemplate sqlSession;

	@Override
	public void addFile(ZzacherDTO file) {
		this.sqlSession.insert("add", file);
	}

	@Override
	public void deleteFile(int no) {
		this.sqlSession.delete("del", no);
	}
	
	@Override
	public ZzacherDTO findByBoardNo(int board_no) {
		return this.sqlSession.selectOne("one", board_no);
	}
}

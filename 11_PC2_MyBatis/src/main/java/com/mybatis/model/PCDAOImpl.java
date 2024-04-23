package com.mybatis.model;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PCDAOImpl implements PCDAO {
	
	@Inject
	private SqlSessionTemplate sqlSession;

	@Override
	public List<PC> getPCList() {
		return this.sqlSession.selectList("all");
	}

	@Override
	public int insertPC(PC dto) {
		return this.sqlSession.insert("insert", dto);
	}

	@Override
	public PC getPC(int no) {
		return this.sqlSession.selectOne("chosen", no);
	}

	@Override
	public int updatePC(PC dto) {
		return this.sqlSession.update("update", dto);
	}

	@Override
	public int deletePC(int no) {
		return this.sqlSession.delete("delete", no);
	}

	@Override
	public void updateSeq(int no) {
		this.sqlSession.update("Seq", no);
		
	}

	@Override
	public List<PC> searchPCList(Map<String, String> map) {
		return this.sqlSession.selectList("map", map);
	}
}
